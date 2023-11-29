package _01_EL;

import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @create 2023-05-14 10:30
 */
public class Person {
    //    i.需求---输出Person类中的普通属性，数组属性。list集合属性和map集合属性。
    private int id;
    private String name;
    private List<String> citis;
    private Map<String,Object> map;

    public Person() {
    }

    public Person(int id, String name, List<String> citis, Map<String, Object> map) {
        this.id = id;
        this.name = name;
        this.citis = citis;
        this.map = map;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCitis() {
        return citis;
    }

    public void setCitis(List<String> citis) {
        this.citis = citis;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citis=" + citis +
                ", map=" + map +
                '}';
    }
}
