package demo1;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.swing.text.Document;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) throws DocumentException {
        //1.读取文件
        Document document= (Document) new SAXReader().read(Demo4.class.getClassLoader().getResource("contect.fxml"));
        //2.创建链接
        List<Contact> list=new ArrayList<Contact>();



    }
}
