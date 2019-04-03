package myEverything.core.model;

import lombok.Data;

//文件属性之后的记录用Thing表示
@Data//get、set方法生成
public class Thing {   //数据库中存储的对象
    //只保留文件名称：D：/a/b/hello.java——-hello.java
    private String name;
    //文件路径
    private String path;
    //文件深度
    private Integer depath;
    //文件类型
    private FileType fileType;





}
