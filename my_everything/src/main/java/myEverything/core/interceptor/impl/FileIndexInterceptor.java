package myEverything.core.interceptor.impl;

import myEverything.core.common.FileConverThing;
import myEverything.core.dao.FileIndexDao;
import myEverything.core.interceptor.FileInterceptor;
import myEverything.core.model.Thing;

import java.io.File;

//打印拦截器
//将file转换为thing写入数据库
public class FileIndexInterceptor implements FileInterceptor {
    private final FileIndexDao fileIndexDao;

    public FileIndexInterceptor(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }


    @Override
    public void apply(File file) {
        Thing thing=FileConverThing.conver(file);
        this.fileIndexDao.insert(thing);
    }
}
