package cn.mldn.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ResourceBundle;


class Factory { //工厂类，这个工厂类首先是为了Message服务的
    public static Message getInstance(String className) {
        Message msg = null;
        try {
            msg = (Message) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface MyFactoryClass {
    public String className();//需要设置Class的包.类名称
}

interface Message {
    public void print(String str);
}

class news implements Message {

    @Override
    public void print(String str) {
        System.out.println("新闻消息" + str);
    }
}
class email implements Message {

    @Override
    public void print(String str) {
        System.out.println("邮箱消息" + str);
    }
}

@MyFactoryClass(className = "cn.mldn.test.email")
public class TestDemo {


    public static void main(String[] args) {
        Message msg = getMsg();
        msg.print("123");
    }

    static Message getMsg(){
        Class<?> cls = TestDemo.class;
        //取得在此配置的Annotation
        MyFactoryClass an = cls.getAnnotation(MyFactoryClass.class);
        String className = an.className();
        Message instance = Factory.getInstance(className);

        return instance;
    }


}
