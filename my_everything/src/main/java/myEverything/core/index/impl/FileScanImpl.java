package myEverything.core.index.impl;

import lombok.Getter;
import myEverything.config.EverythingConfig;
import myEverything.core.EverythingManager;
import myEverything.core.index.FileScan;
import myEverything.core.interceptor.FileInterceptor;
import myEverything.core.interceptor.impl.FilePrintInterceptor;

import java.io.File;
import java.util.LinkedList;
import java.util.Set;

public class FileScanImpl implements FileScan {

    private final LinkedList<FileInterceptor> interceptors= new LinkedList<>();
    @Getter
    private EverythingConfig config=EverythingConfig.getInstance();
    @Override
    public void index(String path) {
        Set<String> excludePaths=config.getHandlerPath().getExcludePath();
        /*
        *判断 A path是否在B path中,B.startwhith（A）
         */

        for (String excludePath:excludePaths) {
            if (path.startsWith(excludePath)){
                return;
            }
        }
        File file=new File(path);
        if (file.isDirectory()){
            File[] files=file.listFiles();
            if (files!=null){
                for (File f:files) {
                    index(f.getAbsolutePath());
                }
            }
        }
        //找到一个文件就拦截一次
        for ( FileInterceptor  interceptor:this.interceptors) {
            interceptor.apply(file);
        }

    }

    @Override
    public void interceptor(FileInterceptor interceptor) {
        this.interceptors.add(interceptor);

    }

//    public static void main(String[] args) {
//        FileScan fileScan=new FileScanImpl();
//        fileScan.index("F:\\PPT模板");
//    }

}
