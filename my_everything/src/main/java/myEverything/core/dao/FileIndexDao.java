package myEverything.core.dao;

import myEverything.core.model.Condition;
import myEverything.core.model.Thing;
import java.util.List;

    //业务层访问数据库的crud
public interface FileIndexDao {
    //数据库访问对象
    //插入方法——c
    void insert(Thing thing);

    //查询方法——r --根据condition进行查询
    List<Thing> query(Condition condition);

    //删除
    void delete(Thing thing);

    }


