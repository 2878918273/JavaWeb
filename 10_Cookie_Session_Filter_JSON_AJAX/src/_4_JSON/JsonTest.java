package _4_JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @create 2023-05-20 9:32
 */
public class JsonTest {
//    3.1 javaBean和Json的互转
    @Test
    public void test1(){
        Person person = new Person(16,"李素裳");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把java对象转换成json字符串
        String personString = gson.toJson(person);
        System.out.println(personString);
        // fromJson把json字符串转化回Java对象
        //第一个参数是json字符串
        //第二个参数是转换回去的java对象类型
        Person person1 = gson.fromJson(personString, Person.class);
        System.out.println(person1);


    }
//    3.2 List和json的互转
    @Test
    public void test2(){
        List<Person> PersonList = new ArrayList<>();

        PersonList.add(new Person(1,"琉璃"));
        PersonList.add(new Person(2,"裳裳"));

        Gson gson = new Gson();
        String PersonListJson = gson.toJson(PersonList);
        System.out.println(PersonListJson);

        List list = gson.fromJson(PersonListJson, new PersonListType().getType());
        System.out.println(list);

        Person person = (Person)list.get(0);
        System.out.println(person);
    }

//    3.3 map和json的互转
    @Test
    public void Test3(){
        Map<Integer, Person> PersonhashMap = new HashMap<>();
        PersonhashMap.put(1,new Person(1,"琉璃"));
        PersonhashMap.put(2,new Person(2,"裳裳"));
        PersonhashMap.put(3,new Person(3,"芷柔"));
        System.out.println(PersonhashMap);

        Gson gson = new Gson();
        //把map集合转换成为json字符串
        String PersonMapString = gson.toJson(PersonhashMap);
        System.out.println(PersonMapString);

//        Map<Integer,Person> Personmap = gson.fromJson(PersonMapString, new PersonMapType().getType());
        //使用匿名内部类减少项目中继承TypeToken的类的创建                                                创建匿名内部类记得加{}
        Map<Integer,Person> Personmap = gson.fromJson(PersonMapString, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(Personmap.get(1).getName());




    }


}
