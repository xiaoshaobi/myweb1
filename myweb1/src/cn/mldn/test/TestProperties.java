package cn.mldn.test;

import java.io.*;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args)  {
        try {
            function3();
        } catch (IOException e) {
            e.getMessage();
        }
        System.getProperties().getProperty("user.dir");

    }

    /**
     * 使用properties保存文件
     * @throws FileNotFoundException
     * @throws IOException
     */
   static void function1()throws FileNotFoundException, IOException{
        Properties pro = new Properties();
        pro.setProperty("message.classname","cn.mldn.demo.News");
        pro.setProperty("city","北京");
        pro.store(new FileOutputStream(new File("E:"+File.separator+"testFile"+File.separator+"info.properties")),"this message file");

    }

    /**
     * 使用properties读取文件
     * @throws FileNotFoundException
     * @throws IOException
     */
    static void function2()throws FileNotFoundException, IOException{
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("E:"+File.separator+"testFile"+File.separator+"info.properties")));
        System.out.println(pro.getProperty("message.classname"));
    }


    /**
     * 不使用任何路径保存文件
     * @throws FileNotFoundException
     * @throws IOException
     */
    static void function3()throws FileNotFoundException, IOException{
        Properties pro = new Properties();
        pro.setProperty("message.classname","cn.mldn.demo.News");
        pro.setProperty("city","北京");
        pro.store(new FileOutputStream(new File("info.properties")),"this message file");

    }

}
