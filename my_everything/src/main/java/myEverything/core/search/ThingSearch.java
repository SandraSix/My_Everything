package myEverything.core.search;

import myEverything.core.model.Thing;

import java.util.List;
import java.util.concurrent.locks.Condition;

/*
* 文件搜索业务
* */
public interface ThingSearch {
    //根据condition的条件进行检索
    List<Thing> search(Condition condition);
}
