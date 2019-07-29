package cn.mldn;

import java.lang.reflect.Field;

class Dept1 {
    private String dname;
}

public class testField2 {

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("cn.mldn.Dept1");
        Object obj = cls.newInstance();
        Field field = cls.getDeclaredField("dname");
        field.setAccessible(true);
        field.set(obj, "财务部");
        System.out.println(field.get(obj));
    }
}
