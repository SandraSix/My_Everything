package myEverything.core.common;


import myEverything.core.model.FileType;
import myEverything.core.model.Thing;

import java.io.File;

//文件对象转换为thing的辅助类
public class FileConverThing {
    public static Thing conver(File file){
        Thing thing=new Thing();
        thing.setName(file.getName());
        thing.setPath(file.getAbsolutePath());
        /*
        * 目录时递归查看
        * 文件时，获取扩展名，通过扩展名获取FileType
        * */
        int index=file.getName().lastIndexOf(".");
        String extend="*";
        if (index!=-1 && (index+1)<file.getName().length()){
        extend=file.getName().substring(index+1);
    }
    thing.setFileType(FileType.lookupByExtend(extend));
    thing.setDepath(computePathDepth(thing.getPath()));
    return thing;
    }

    public static int computePathDepth(String path) {
        //由path计算depath——有几个\深度为几
        int depath=0;
        for (char c:path.toCharArray()
             ) {
            if (c==File.separatorChar){
                depath++;
            }
        }

        return depath;
    }

//    public static void main(String[] args) {  //测深度
//        String path="C:\\dd\\tet.doc";
//        System.out.println(computePathDepth(path));
//    }

//    public static void main(String[] args) {
//        File file=new File("C:\\dd\\dx\\tet.doc");
//        Thing thing=FileConverThing.conver(file);
//        System.out.println(thing);
//    }


}
