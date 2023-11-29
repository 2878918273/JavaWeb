package _02_dom4j解析xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author wx
 * @create 2023-05-09 13:42
 */
public class Dom4jTest {
    @Test
    public void book_test() throws Exception {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/xml/books.xml");

        System.out.println(document);
    }

    /*
        读取books.xml文件生成book类
     */

    @Test
    public void test_2() throws Exception {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        // 在junit测试中，相对路径是从模块名开始算
        Document read = saxReader.read("src/xml/books.xml");

        //2.通过Document对象获取根元素
        Element rootElement = read.getRootElement();
//        System.out.println(rootElement);
        //3.通过根元素获取book标签对象
        List<Element> books = rootElement.elements("book");
        //4.遍历，处理每个book标签转换成Book类
        for (Element book : books){
            String sn = book.attributeValue("sn");

            //elementText("name") 直接获取指定标签名的文本内容
            String name = book.elementText("name");
            String title = book.elementText("title");
            String author = book.elementText("author");

            System.out.println(new Book(sn,name,title,author));
        }
    }

}
