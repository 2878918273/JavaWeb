package _01_EL;
/*
1. EL表达式
    什么是EL表达式，EL表达式的作用?
        EL表达式的全称是：Expression Language。是表达式语言
        EL表达式的作用：EL表达式主要是代替jsp页面中的表达式脚本在jsp页面中进行数据的输出。
        因为EL表达式在输出数据的时候，要比jsp表达式脚本简洁
EL表达式的格式是：${表达式}
EL表达式在读取到null值的时候，输出的是空串。jsp表达式脚本读取到null值的时候，输出的是null字符串

2.EL表达式搜索域数据的顺序
    EL表达式主要是在jsp页面中输出数据。
    主要是输出域对象中的数据
    当四个域中都有相同的key的数据的时候，EL表达式会按照四个域的大小从小到大的顺序去进行搜索，找到就输出
                                        pageContext < request < session < application

3.EL表达式输出Bean的普通属性，数组属性。List集合属性，map集合属性
    i.需求---输出Person类中的普通属性，数组属性。list集合属性和map集合属性。





*/

/**
 * @author wx
 * @create 2023-05-14 10:04
 */
public class _1_View {

}


