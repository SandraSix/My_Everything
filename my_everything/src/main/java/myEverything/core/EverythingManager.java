package myEverything.core;

import jdk.nashorn.internal.objects.annotations.Getter;
import myEverything.config.EverythingConfig;
import myEverything.config.HandlerPath;
import myEverything.core.dao.DataSourceFactory;
import myEverything.core.dao.FileIndexDao;
import myEverything.core.dao.Impl.FileIndexDaoImpl;
import myEverything.core.index.FileScan;
import myEverything.core.index.impl.FileScanImpl;
import myEverything.core.interceptor.impl.FileIndexInterceptor;
import myEverything.core.interceptor.impl.FilePrintInterceptor;
import myEverything.core.model.Condition;
import myEverything.core.model.Thing;
import myEverything.core.search.ThingSearch;
import myEverything.core.search.impl.ThingSearchImpl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

//核心调度器:——-单例模式
/*1.索引 ——后台执行
 *2.检索 ——立即执行
 *
 * 配置类：
 * 1.索引目录：包含的目录、排除的目录、通过参数设置是否开启索引线程
 * 2.查询按照depath的升序or降序
 * 3.查询的结果数量限制
 *
 * 如何将索引模块、检索模块、拦截器模块组合调度
 *
 */
public class EverythingManager {

    private static volatile EverythingManager manager;

    private FileScan fileScan;

    private ThingSearch thingSearch;

    //线程池执行器
    private final ExecutorService executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
    private EverythingConfig everythingConfig=EverythingConfig.getInstance();

    private EverythingManager(){
        FileIndexDao fileIndexDao = new FileIndexDaoImpl(DataSourceFactory.getInstance());
        this.fileScan=new FileScanImpl();
        //打印索引信息的拦截器
        //this.fileScan.interceptor(new FilePrintInterceptor());
        //索引信息写数据库的拦截器
        this.fileScan.interceptor(new FileIndexInterceptor(fileIndexDao));
        this.thingSearch=new ThingSearchImpl(fileIndexDao);
    }

    public static EverythingManager getInstance(){
        //double check
        if (manager==null){
            synchronized (EverythingManager.class){
                if (manager==null){
                    manager=new EverythingManager();
                }
            }
        }
        return manager;
    }

@Getter
    //构建索引
    public void buildIndex() {
        DataSourceFactory.databaseInit(true);//每次索引都重建一张表
        HandlerPath handlerPath=everythingConfig.getHandlerPath();
        Set<String> includePaths=handlerPath.getIncludePath();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Build index start...");
                CountDownLatch countDownLatch=new CountDownLatch(includePaths.size());
                for (String path:includePaths){
                    executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                            fileScan.index(path);
                            countDownLatch.countDown();
                        }
                    });
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Build index complete...");
            }
        }).start();


    }

    //检索功能
    public List<Thing> search(Condition condition){
        //用户可提供name和filetype，限制和排序方式默认
        condition.setLimit(everythingConfig.getMaxReturn());
        condition.setOrderByAsc(!everythingConfig.getOrderByDesc());

        System.out.println(condition);
        //还有问题：condition
        return this.thingSearch.search(condition);
    }
    //帮助功能
    public void help(){
        System.out.println("命令列表：");
        System.out.println("退出：quit");
        System.out.println("帮助：help");
        System.out.println("索引：index");
        System.out.println("搜索：search <name> [<file-Type> img | doc | bin | archive | other ]");
    }
    //退出功能
    public void quit(){
        System.out.println("谢谢使用,再见！");
        System.exit(0);
    }

}
