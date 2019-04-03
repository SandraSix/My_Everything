package demo1;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import javax.print.Doc;
import java.io.File;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        //创建解析器对象
        SAXReader reader=new SAXReader();
        //读取文件
        //方式1：绝对路径
        //Document doc=reader.read(new File("F:\\BitJavaCode\\XML_contect\\XML_contect.iml"));
        //方式2：通过获取Demo的字节码文件，获取类加载器获取资源文件
        /*
        * 获取一个类的字节码对象的方式：
        * 1.任何数据类型的class属性—— .class
        * 2.实际开发中：Class.forName("字符串")
        * 3.Object类的getClass（）方法*/
        Document doc=reader.read(Demo1.class.getClassLoader().getResource("XML_contect.iml"));
        System.out.println(doc);
    }
}
