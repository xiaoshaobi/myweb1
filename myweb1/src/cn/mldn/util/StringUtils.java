package cn.mldn.util;

public class StringUtils {

    public static String initcap(String str){
        if(str==null||"".equals(str)){//保证操作的数据有内容
            return str;
        }
        if(str.length()==1){//只有一位数据

            return str.toUpperCase();//全部变大写
        }else{
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }

}