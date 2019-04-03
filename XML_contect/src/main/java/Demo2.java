import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws DocumentException {
        //创建解析器对象
        SAXReader reader=new SAXReader();
        //加载资源文件
        Document doc=reader.read(Demo2.class.getClassLoader().getResource("contect.xml"));
        //获取基本的api：1.获取根节点对象
        Element conList=doc.getRootElement();
        System.out.println(conList);
        //2.获取标签名称：node对象.getName（）
        System.out.println(conList.getName());
        //3.获取子标签对象：element("contact")——默认获取第一个自标签对象
        Element conElement=conList.element("contect");
        //4.获取同名的所有标签对象:elements("contact")
        List<Element> list=conList.elements("contect");
        /*注：遍历集合的方式   1.普通for循环；
         *                  2.迭代器：Iterator（）
         *                  3.增强for循环：foreach——替代迭代器*/
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Element e:list){
            System.out.println(e);
        }

        //获取当前节点下的所有子节点：返回List<Element>
        List<Element> list1=conList.elements();
        for (Element e:list1
             ) {
            System.out.println(e);

        }

        //获取name标签对象：要先获取它的父标签对象
        Element nameElement=conList.element("contect").element("name");
        System.out.println(nameElement);
    }
}
