package myEverything.core.interceptor;


import myEverything.core.model.Thing;

//在检索结果出来后，再次进行拦截——有文件删除时，同时要删除数据库中的索引
public interface ThingInterceptor {
    void apply(Thing thing);
}
