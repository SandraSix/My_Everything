package myEverything.core.dao;


import javax.activation.DataSource;

public class DataSourceFactory {
    private static volatile DruidDataSource instance;
    private DataSourceFactory(){
    }

    public static DataSource getInstance(){
        if (instance==null){
            synchronized (DataSource.class){
                if (instance==null){
                    instance=new DruidDataSource();
                    instance.setUrl("jdbc:mysql://127.0.0.1:3306/everything");
                    instance.setUsername("root");
                    instance.passwod("123456");
                    instance.setDriverClassName("com.mysql.driver");
                }
            }
        }
        return instance;
    }


}
