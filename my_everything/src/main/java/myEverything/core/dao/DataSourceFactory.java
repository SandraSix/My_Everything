package myEverything.core.dao;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import myEverything.core.model.Condition;
import myEverything.core.model.Thing;

//import javax.activation.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Getter
public class DataSourceFactory {
    //采用单例模式
    private static volatile DruidDataSource instance;
    private DataSourceFactory(){
    }

    public static DruidDataSource getInstance(){
        if (instance==null){
            synchronized (DataSource.class){
                if (instance==null){
                    instance=new DruidDataSource();

                    //获取当前工程的路径System.getProperty("user.dir")
                    //获取当前用户的目录System.getProperty("user.home")
                    //也可以自定义路径：绝对路径

                    instance.setTestWhileIdle(false);
                    instance.setDriverClassName("org.h2.Driver");
                    String workdir=System.getProperty("user.dir");
                    instance.setUrl("jdbc:h2:"+workdir+ File.separator+"everything");
                    //初始化数据库，建库之后就初始化表
                    databaseInit(false);

                        //mysql的配置
//                    instance.setUrl("jdbc:mysql://127.0.0.1:3306/everything");
//                    instance.setUsername("root");
//                    instance.setPassword("123456");
//                    instance.setDriverClassName("com.mysql.jdbc.Driver");
                }

            }
        }
        return instance;
    }

    public static void databaseInit(boolean buildIndex){

        StringBuilder sb=new StringBuilder();
        try (InputStream in=DataSourceFactory.class.
                getClassLoader().getResourceAsStream("database.sql");
        ){
            if (in!=null){
                try (BufferedReader reader=new BufferedReader(new InputStreamReader(in)))
                {
                    String line=null;
                    while ((line=reader.readLine())!=null){
                        sb.append(line);
                    }

                }catch (IOException e){
                 e.printStackTrace();
                }
            }else {
                throw new RuntimeException("data.sql脚本错误，无法加载，请检查");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String sql=sb.toString();

        try(Connection connection=getInstance().getConnection();
        ) {
            if (buildIndex){
                try (PreparedStatement statement=connection.prepareStatement("drop table if exists thing;")){
                    statement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
            try (PreparedStatement statement=connection.prepareStatement(sql);){
                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试能否建表插入
//    public static void main(String[] args) {
//        DataSource dataSource= (DataSource) DataSourceFactory.getInstance();
//        Thing thing=new Thing();
//        try {
//            Connection connection=dataSource.getConnection();
//
//            PreparedStatement statement=connection.prepareStatement
//                    ("insert into thing (name,path,depath,file_type) values (?,?,?,?)");
//            {
//                statement.setString(1,"文件1.pdf");
//                statement.setString(2,"D:\\text\\文件1.pdf");
//                statement.setInt(3,2);
//                statement.setString(4,"DOC");
//                statement.executeUpdate();
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    public static void main(String[] args) {
//        DruidDataSource dataSourceFactory=DataSourceFactory.getInstance();
//        System.out.println(dataSourceFactory);
//    }

    //初始化数据库
//    public static void initDatabase(){
//        //1.获取数据源；
//        // 2.获取sql语句
//        try(InputStream in=DataSourceFactory.class.getClassLoader().getResourceAsStream("myEverything.sql")){
//            //该语句获取了当前类的类加载器
//            if (in==null){
//                throw new RuntimeException("数据库初始化脚本错误！");
//            }
//            StringBuilder sqlBuilder=new StringBuilder();
//
//            try(BufferedReader reader=new BufferedReader(new InputStreamReader(in))){
//                String line=null;
//                while((line=reader.readLine())!=null){
//                    if (!line.startsWith("--")){
//                        sqlBuilder.append(line);
//                    }
//                }
//            }
//
//            //3.获取数据库连接和sql语句
//            String sql=sqlBuilder.toString();
//            //进行jdbc链接
//
//                //1.创建链接
//                Connection connection=instance.getConnection();
//                //2.获取sql语句
//                PreparedStatement statement=connection.prepareStatement(sql);
//                //3.执行sql语句
//                statement.execute();
//                //4.关闭流
//                connection.close();
//                statement.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        DataSourceFactory.databaseInit(false);
    }

}
