package _02_dom4j解析xml;

/**
 * @author wx
 * @create 2023-05-09 13:33
 */
public class Book {

    private String sn;
    private String name;
    private String title;
    private String author;

    public Book() {
    }

    public Book(String sn, String name, String title, String author) {
        this.sn = sn;
        this.name = name;
        this.title = title;
        this.author = author;
    }


    public String getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
