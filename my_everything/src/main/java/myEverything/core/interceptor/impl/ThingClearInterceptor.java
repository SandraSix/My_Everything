package myEverything.core.interceptor.impl;

import myEverything.core.dao.FileIndexDao;
import myEverything.core.interceptor.ThingInterceptor;
import myEverything.core.model.Thing;

import java.util.Queue;

//
public class ThingClearInterceptor implements ThingInterceptor ,Runnable{

    private final FileIndexDao fileIndexDao;
    private final Queue<Thing> thingQueue;

    public ThingClearInterceptor(FileIndexDao fileIndexDao,Queue<Thing> thingQueue) {
        this.fileIndexDao = fileIndexDao;
        this.thingQueue = thingQueue;
    }

    @Override
    public void apply(Thing thing) {
        this.fileIndexDao.delete(thing);
    }

    @Override
    public void run() {
        //jinxingqingli
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thing thing=this.thingQueue.poll();//
            if (thing!=null){
                this.apply(thing);

            }
        }
    }
}
