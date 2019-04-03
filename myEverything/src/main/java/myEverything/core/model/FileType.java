package myEverything.core.model;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FileType {
/**
 * */
    public enum FileType{
        IMG("jpg","jpeg","bmp","gif"),
        DOC("doc","xdoc"),
        BIN("exe","jar","sh"),
        ARCHIVE("zip","rar"),
        OTHER("*");
        private Set<String> extend=new HashSet<>();

        FileType(String... extend){
            this.extend.addAll(Arrays.asList(extend));
        }

        public static FileType lookupFileType(String extend){
            for (FileType fileType:FileType.values()){
                if (fileType.name().equals(name)){
                    return fileType;
                }

            }
            return FileType;
        }
    }

    public static void main(String[] args) {

    }


}
