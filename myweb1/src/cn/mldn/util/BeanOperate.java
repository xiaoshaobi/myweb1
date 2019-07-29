package cn.mldn.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 本类的功能是根据属性的名称与属性设置传递的内容
 */
public class BeanOperate {


    private Object obj;
    private String property;
    private String value;
    private Field field;//要操作的属性
    private String fieldName;//保存成员的名称
    private Object currentObject;//操作属性的对象

    /**
     * 本类里面实际上只需要一些基本信息
     *
     * @param obj      操作的对象
     * @param property 属性名称
     * @param value    set的值
     */
    public BeanOperate(Object obj, String property, String value) {
        this.obj = obj;
        this.property = property;
        this.value = value;
        handleString();
        setFieldValue();
    }

    public Field getField() {
        return field;
    }

    public Object getCurrentObject() {
        return currentObject;
    }

    /**
     * 此操作核心功能就是要处理字符串，从里面区别出要操作的属性以及对象
     */
    private void handleString() {
        String[] result = this.property.split("\\.");//按照.拆分,长度最少为2
        this.currentObject = this.obj;//设置一个当前操作对象:

        try {
            if (result.length == 2) {
                this.field = currentObject.getClass().getField(result[1]);
                this.fieldName=result[1];

            } else {
                for (int i = 1; i < result.length; i++) {


                    //getter方法没有参数，getMethod时不需要传递参数类型
                    Method declaredMethod = currentObject.getClass()
                            .getDeclaredMethod("get" + StringUtils.initcap(result[i]));
                    this.fieldName=result[i];//保存成员名称
                    this.field = currentObject.getClass().getDeclaredField(result[i]);

                    if (i < result.length - 1) {//后面还有对象
                        currentObject = declaredMethod.invoke(currentObject);
                    }


                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置指定属性的内容,所有的操作一定要调用setter方法
     */
    private void setFieldValue() {
        try {
            Method met = this.currentObject.getClass()
                    .getDeclaredMethod(
                            "set" + StringUtils.initcap(this.fieldName),
                            this.field.getType());  //找到设置的setter方法。
            String type=this.field.getType().getSimpleName();
            if("int".equalsIgnoreCase(type)
                    ||"Integer".equalsIgnoreCase(type)){
                //属于数字类型
                if(this.value.matches("\\d+")){
                    met.invoke(currentObject,Integer.parseInt(this.value));
                }
            }else if("double".equalsIgnoreCase(type)){
                if(this.value.matches("\\d+(\\.\\d+)?")){
                    met.invoke(currentObject,Double.parseDouble(this.value));
                }

            }

            met.invoke(currentObject,this.value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
