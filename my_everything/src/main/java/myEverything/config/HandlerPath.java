package myEverything.config;

import lombok.Getter;
import lombok.ToString;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@ToString
//处理的目录
public class HandlerPath {
    private Set<String> includePath=new HashSet<>();
    private Set<String> excludePath=new HashSet<>();
    public HandlerPath(){

    }

    public void addIncludePath(String path) {
        this.includePath.add(path);
    }

    public void addExcludePath(String path){
        this.excludePath.add(path);
    }

    public static HandlerPath getDefaultHandlerPath(){
        //获取盘符
        HandlerPath handlerPath=new HandlerPath();
        Iterable<Path> paths=FileSystems.getDefault().getRootDirectories();
        paths.forEach(path -> {
            handlerPath.addIncludePath(path.toString());
        });
        //默认排除的目录
        String sysytemName=System.getProperty("os.name");
        if (sysytemName.contains("Windows")){
            //排除windows的目录
            handlerPath.addExcludePath("C:\\Windows");
            handlerPath.addExcludePath("C:\\Program Files");
            handlerPath.addExcludePath("C:\\Program File(x86)");
            handlerPath.addExcludePath("C:\\ProgramData");

        }else {
            //linux排除的目录
            handlerPath.addExcludePath("/root");
            handlerPath.addExcludePath("/temp");

        }
        return handlerPath;
    }

    public static void main(String[] args) {
        System.out.println(HandlerPath.getDefaultHandlerPath());
    }

}
