package myEverything.core.dao.Impl;

import myEverything.core.dao.DataSourceFactory;
import myEverything.core.dao.FileIndexDao;
import myEverything.core.model.Condition;
import myEverything.core.model.FileType;
import myEverything.core.model.Thing;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileIndexDaoImpl implements FileIndexDao {
    private final DataSource dataSource;
    //数据源
    public FileIndexDaoImpl(DataSource dataSource) {

        this.dataSource = dataSource;
    }


    @Override
    public void insert(Thing thing) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            //1.获取链接
            connection=this.dataSource.getConnection();
            //2.sql语句
            String sql="insert into thing (name,path,depath,file_type) values(?,?,?,?)";
            //3.准备命令
            statement=connection.prepareStatement(sql);

            statement.setString(1,thing.getName());
            statement.setString(2,thing.getPath());
            statement.setInt(3,thing.getDepath());
            statement.setString(4,thing.getFileType().name());

            //5.执行命令
            statement.executeUpdate();
        }catch (SQLException e){

        }finally {
            releaseResource(null,statement,connection);
        }
    }



    @Override
    public List<Thing> query(Condition condition) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Thing> things=new ArrayList<>();
        try{
            //1.获取链接
            connection=dataSource.getConnection();
            //2.sql语句
            //String sql="select name,path,depath,file_type from file_index";

            //name——后模糊匹配查询----%
            //filetype——准确查询----=
            //查询结果按文件深度升序排列
            // StringBuilder比Stringbuffer效率高，异步操作
            StringBuilder sqlBuilder=new StringBuilder();
            sqlBuilder.append(" select name,path,depath,file_type from thing ");

            sqlBuilder.append(" where ")
                    .append(" name like '")
                    .append(condition.getName())
                    .append("%' ");
            if (condition.getFiletype()!=null){
                sqlBuilder.append(" and file_type='")
                        .append(condition.getFiletype().toUpperCase())
                        .append("'");
            }
            System.out.println(sqlBuilder.toString());
//            //limit和orderby的实现,先排序
            sqlBuilder.append(" order by depath ")
                    .append(condition.getOrderByAsc() ? "asc" : "desc");

            sqlBuilder.append(" limit ")
                    .append(condition.getLimit());

            //3.准备命令
            statement=connection.prepareStatement(sqlBuilder.toString());
            //5.执行命令
            resultSet=statement.executeQuery();
            //6.处理结果
            while (resultSet.next()){
                Thing thing=new Thing();
                thing.setName(resultSet.getString("name"));
                thing.setPath(resultSet.getString("path"));
                thing.setDepath(resultSet.getInt("depath"));
                thing.setFileType(FileType.lookupByName(resultSet.getString("fileType")));
                things.add(thing);

                for (Thing thing1:things) {
                    System.out.println(thing1);
                }
            }
        }catch (SQLException e){

        }finally {
            releaseResource(resultSet,statement,connection);
        }

        return things;
    }

    @Override
    public void delete(Thing thing) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            //1.获取链接
            connection=this.dataSource.getConnection();
            //2.sql语句__难点：删除时应该递归的删除
            //解决：like path%
            String sql="delete from thing where path=?";

            //3.准备命令
            statement=connection.prepareStatement(sql);
            statement.setString(1,thing.getPath());

            //5.执行命令
            statement.executeUpdate();
        }catch (SQLException e){

        }finally {
            releaseResource(null,statement,connection);
        }
    }

    //解决关闭代码的重复——代码重构
    private void releaseResource(ResultSet resultSet,PreparedStatement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

//测试代码
//    public static void main(String[] args) {
//        DataSource dataSource= (DataSource) DataSourceFactory.getInstance();
//        FileIndexDao dao=new FileIndexDaoImpl(dataSource);
//
//        Condition condition=new Condition();
//        condition.setName("文件1.pdf");
//        //condition.setFiletype("doc");
//        List<Thing> things=dao.query(condition);
//        for (Thing thing:things) {
//            System.out.println(thing);
//        }
//
//    }

}
