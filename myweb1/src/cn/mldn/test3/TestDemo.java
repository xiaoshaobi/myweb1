package cn.mldn.test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;

class Book {
    private String title;
    private Double price;

    public Book(String title)throws  Exception {
        this.title = title;
    }

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

public class TestDemo {

    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("cn.mldn.test3.Book");
            try {
                Constructor<?> constructor = cls.getConstructor(String.class);
                try {
                    Book instance = (Book)constructor.newInstance("java编程思想");
                    System.out.println(instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
