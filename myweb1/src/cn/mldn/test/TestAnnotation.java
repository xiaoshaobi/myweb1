package cn.mldn.test;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Properties;

@Retention(value=RetentionPolicy.RUNTIME)
@interface MyFactory{  //定义一个属于自己的Annotation
   public String name() default "mldn";
   public String val();
}

@MyFactory(val = "hello")
@SuppressWarnings("serial")
@Deprecated
class Student implements Serializable {

}
public class TestAnnotation {

    public static void main(String[] args) {
        Class<?> cls = Student.class;
        Annotation [] an=cls.getAnnotations();//取得全部Annotation
        for (Annotation annotation : an) {
            System.out.println(annotation);
        }
    }

    static void function1(){
        Class<?> cls = Student.class;
        MyFactory an = cls.getAnnotation(MyFactory.class);
        System.out.println(an.name());
        System.out.println(an.val());
    }


}
