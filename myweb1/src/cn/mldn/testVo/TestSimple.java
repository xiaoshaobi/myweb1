package cn.mldn.testVo;

import cn.mldn.util.BeanOperate;

public class TestSimple {

   static Emp emp=new Emp();//实例化对象提供

    public static void main(String[] args) {
        String attributeName = "emp.dept.company.name";
        //emp是一个对象，通过此对象找到的是getDept()方法
        String value = "720诈骗公司";
        BeanOperate beanOperate=new BeanOperate(emp,attributeName,value);
        System.out.println(beanOperate.getField().getName());
        System.out.println(beanOperate.getCurrentObject().getClass().getSimpleName());
        System.out.println(emp.getDept().getCompany().getName());
    }

}
