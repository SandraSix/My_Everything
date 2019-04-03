package myEverything.core.search.impl;

import myEverything.core.dao.FileIndexDao;
import myEverything.core.interceptor.impl.ThingClearInterceptor;
import myEverything.core.model.Thing;
import myEverything.core.search.ThingSearch;
//import myEverything.core.model.Condition;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;

public class ThingSearchImpl implements ThingSearch {
    //阻塞队列
    private final Queue<Thing> thingQueue=new ArrayBlockingQueue<>(1024);
    private final FileIndexDao fileIndexDao;
    private final ThingClearInterceptor interceptor;
    //final修饰的变量初始化方式：1.直接赋值；2.构造方法赋值；3.构造块赋值
    public ThingSearchImpl(FileIndexDao fileIndexDao) {

        this.fileIndexDao = fileIndexDao;
        this.interceptor=new ThingClearInterceptor(this.fileIndexDao,thingQueue);
        this.backgroundClearThread();

    }

    @Override
    public List<Thing> search(Condition condition) {

        //检索过程   依赖数据库检索
        //本地系统中已经删除的文件，应该在数据库中清除该文件的索引信息

        //*****condition还有问题****
        List<Thing> things = this.fileIndexDao.query((myEverything.core.model.Condition) condition);
        Iterator<Thing> iterator = things.iterator();
        while (iterator.hasNext()) {
            Thing thing = iterator.next();
            File file = new File(thing.getPath());
            if (!file.exists()) {
                //删除已经不存在的文件  的索引
                iterator.remove();
                //会存在IO阻塞————解决：生产者消费者模型
                this.thingQueue.add(thing);
            }
        }

        return things;
    }

    private void backgroundClearThread(){
        //后台清理工作
        Thread thread=new Thread(this.interceptor);//interceptor继承了runnable接口
        thread.setName("Thread-Clear");
        thread.setDaemon(true);//设为守护线程
        thread.start();

    }
}
