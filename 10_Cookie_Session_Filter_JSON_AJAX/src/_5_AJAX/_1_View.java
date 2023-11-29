package _5_AJAX;

/*
AJAX请求

1.什么是AJAX请求
    AJAX即“Asynchronous Javascript And XML”（异步JavaScript 和 XML），是指一种创建交互式网页应用的网页开发技术。
    ajax是一种浏览器通过js异步发起请求，局部更新页面的技术。

2.XMLHttpRequest对象
所有现代浏览器均支持XMLHttpRequest对象
XMLHttpRequest用于在后台与服务器交换数据。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。
    向服务器发送请求
    方法：使用open(method,url,async)  （method：请求的类型，url：文件在服务器上的位置，async：true(异步)或false(同步)）
           和send()

onreadystatechange事件：当请求被发送到服务器时，我们需要执行一些基于响应的任务。每当readyState改变时，
                        就会触发readyState事件,readyState属性存有XMLHttpRequest的状态信息。
                        下面是XMLHttpRequest对象的三个重要的属性：
                        onreadystatechange: 存储函数（或函数名），每当readyState属性改变时，就会调用该函数
                        readyState: 存有XMLHttpRequest的状态。从0到4发生变化。
                                    0：请求未初始化
                                    1：服务器连接已建立
                                    2：请求已接收
                                    3：请求处理中
                                    4：请求已完成，且响应已就绪
                        status：200："OK"
                                404:未找到页面

Ajax请求局部更新，浏览器地址栏不会发生变化，局部更新不会舍弃原来页面的内容

2.JQuery中AJAX请求
$ajax方法
    url             表示请求的地址
    type            表示请求的类型GET或POST请求
    data            表示发送给服务器的数据
                    格式有两种：
                        1：name=value&name=valus
                        2:{key:value}
    successs        请求响应，响应的回调函数
    dataType        响应的数据类型
                        常用的数据类型有：
                            text 表示纯文本
                            xml  表示xml数据
                            json 表示json对象

$.get方法和$.post方法
    url         请求的url地址
    data        发送的数据
    callback    成功的回调函数
    type        返回的数据类型

$.getJSON方法
    url         请求的url地址
    data        发送给服务器的数据
    callback    成功回调的函数

表单序列化serialize()
serialize()可以把表单中所有表单项的内容都获取到，并以name=value&name=value的形式进行拼接





*/



/**
 * @author wx
 * @create 2023-05-24 20:23
 */
public class _1_View {
}
