package _1_介绍;

/*
书城项目中的补充知识点一：ThreadLocal的使用

ThreadLocal的作用，它可以解决多线程数据安全问题。
ThreadLocal它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数据，集合）
ThreadLocal的特点：
        1. ThreadLocal可以为当前线程关联一个数据。（它可以像Map用一样存取数据，key为当前线程）
        2. 每一个hreadLocal对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要多个ThreadLocal对象实例。
        3.每个ThreadLocal对象实例定义的时候，一般都是static类型
        4.ThreadLocal中保存数据，在线程销毁后。会由JVM虚拟自动释放














*/


import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wx
 * @create 2023-05-27 16:57
 */
public class _2_ThreadLocal {

    public static Map<String,Object> data = new ConcurrentHashMap<String,Object>();
    private static Random random = new Random();

    public static class Task implements Runnable{
        @Override
        public void run() {
            //  在Run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(10);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name+"]生成的随机数是：" + i);
            data.put(name,i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            Object o = data.get(name);
            System.out.println("线程[" + name+"]生成的随机数是：" + o);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }


}
