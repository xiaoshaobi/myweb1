package cn.mldn.testmethod;

import cn.mldn.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface Message {
    public void print();
}

abstract class Info {
    public abstract void get();
}

class MessageImpl extends Info implements Message {

    @Override
    public void print() {
    }

    @Override
    public void get() {
    }

    public void set() {
    }//定义自己的方法
}

class Dept{
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}

public class TestDemo {

    public static void main(String[] args) throws Exception {
        //默认一定会提供以下内容
        String className="cn.mldn.testmethod.Dept";//类名称
        String properties="dname";//类属性
        String value="财务部";
        //后面的代码一定是由反射机制进行处理
        Class<?> cls = Class.forName(className);//找到指定类型
        Object obj = cls.newInstance();//实例化
        Field declaredField = cls.getDeclaredField(properties);
        //参数类型还得自己手动填写。属于一个缺陷
        Method method = cls.getMethod("set"+ StringUtils.initcap(properties),declaredField.getType());//获取这个方法
        Method declaredMethod = cls.getDeclaredMethod("get" +StringUtils.initcap(properties));

        method.invoke(obj,value);//调用这个方法并传入实例化对象，有参数就传。
        System.out.println(declaredMethod.invoke(obj));

    }
}