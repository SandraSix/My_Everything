package myEverything.core.index;

import myEverything.core.dao.DataSourceFactory;
import myEverything.core.dao.FileIndexDao;
import myEverything.core.dao.Impl.FileIndexDaoImpl;
import myEverything.core.index.impl.FileScanImpl;
import myEverything.core.interceptor.FileInterceptor;
import myEverything.core.interceptor.impl.FileIndexInterceptor;
import myEverything.core.interceptor.impl.FilePrintInterceptor;

import javax.sql.DataSource;

public interface FileScan {
    //将指定path下的文件，子文件递归扫描，索引到数据库
    void index(String path);

    //增加拦截器对象
    void interceptor (FileInterceptor interceptor);

    //****测试出来：标成功创建，但查询的数据没有放入****
//    public static void main(String[] args) {
//        FileScan fileScan=new FileScanImpl();
//        fileScan.interceptor(new FilePrintInterceptor());
//        DataSource dataSource=DataSourceFactory.getInstance();
//        FileIndexDao fileIndexDao=new FileIndexDaoImpl(dataSource);
//        fileScan.interceptor(new FileIndexInterceptor(fileIndexDao));
//        fileScan.index("F:\\PPT模板");
//    }
}
