package cn.mldn.test;

import java.util.ResourceBundle;

public class TestResourceBundle {

    public static void main(String[] args) {
        //后面不加*.properties
        ResourceBundle rb = ResourceBundle.getBundle("info");
        System.out.println(rb.getString("message.classname"));
    }

}
