package myEverything.core.model;

import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.TimeUnit;
@Setter
@Data
public class Condition implements java.util.concurrent.locks.Condition {  //检索用的参数

    private String name;
    private String filetype;
    private Integer limit;//限制查询结果的数量
    private Boolean orderByAsc;//按文件深度升序排列，默认true升序，false为降序


    @Override
    public void await() throws InterruptedException {

    }

    @Override
    public void awaitUninterruptibly() {

    }

    @Override
    public long awaitNanos(long nanosTimeout) throws InterruptedException {
        return 0;
    }

    @Override
    public boolean await(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean awaitUntil(Date deadline) throws InterruptedException {
        return false;
    }

    @Override
    public void signal() {

    }

    @Override
    public void signalAll() {

    }
}
