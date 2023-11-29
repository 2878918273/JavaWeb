<%@ page import="_01_EL.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setId(1001);
    person.setName("王林");
    List<String> list = new ArrayList<>();
    list.add("list1");
    list.add("list2");
    list.add("list3");
    list.add("list4");
    list.add("list5");

    person.setCitis(list);

    Map<String,Object> map = new HashMap<String,Object>();
    map.put("key1","value1");
    map.put("key2",2);
    map.put("key3","value3");
    map.put("key4","value4");
    map.put("key5","value5");

    person.setMap(map);

    pageContext.setAttribute("Person1",person);

%>
输出Person：${Person1}<br />
输出Person.id : ${Person1.id} <br />
输出Person.name:${Person1.name} <br />
输出Person.citis:${Person1.citis[1]} <br />
输出Person.map:${Person1.map.key1} <br />
<%--实际上调用的不是类中的属性，而是类的方法---%>


</body>
</html>
