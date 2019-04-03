package myEverything.core.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 文件类型
* */
public enum FileType{
    IMG("png","jpeg","jpe","gif"),
    DOC("doc","docx","ppt","pdf","txt","pptx"),
    Bin("exe","jar","sh"),
    ARCHIVE("zip","rar"),
    OTHER("*");
    //对应文件的扩展名集合
    private Set<String> extend=new HashSet<String>();

    private FileType (String... extend){
        this.extend.addAll(Arrays.asList(extend));
    }

    //根据文件扩展名获取文件类型
    public static FileType lookupByExtend(String extend){
        for (FileType fileType:FileType.values()){
            if (fileType.extend.contains(extend)){
                return fileType;
            }
        }
        return FileType.OTHER;
    }

    //根据文件类型名获取文件对象
    public static FileType lookupByName(String name){
        for (FileType fileType:FileType.values()){
            if (fileType.name().equals(name)){
                return fileType;
            }
        }
        return FileType.OTHER;
    }

}
