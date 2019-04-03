package demo1;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.swing.text.Document;
import javax.swing.text.Element;

public class Demo3 {
    public static void main(String[] args) throws DocumentException {
        //读取文件
        //Document document= (Document) new SAXReader().read(Demo3.class.getClassLoader().getResource("contect"));
        //1.获取对象后获取属性
//        Element conElem=document.getDefaultRootElement().getElement(Integer.parseInt("contect")).get(1);
//
//
//        //2.获取属性对象：getName（）/getValue()方法
//        //conElem=document.getRootElement().element("contect");
//        String name=conElem.getName();
//        String id= String.valueOf(conElem.getAttributes());
    }
}
