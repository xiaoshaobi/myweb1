package cn.mldn;


import java.lang.reflect.Field;

interface Message {
    public static final String MSG = "HELLO WORLD!";
}

abstract class Info {
    public static String city = "北京";
    private static String id = "001";
}

class Dept extends Info implements Message {
    private String dname;
}

public class testField {

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("cn.mldn.Dept");
        {
            Field f[] = cls.getFields();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i]);
            }

        }
        System.out.println("**********************");
        {
            Field f[] = cls.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i]);
            }
        }
    }
}
