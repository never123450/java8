package com.xwy.one.optional;

import com.xwy.one.bean.Employee;
import com.xwy.one.bean.Godness;
import com.xwy.one.bean.Man;
import com.xwy.one.bean.NewMan;

import java.util.Optional;

/**
 * @description:
 * @author: xwy
 * @create: 下午6:51 2021/5/28
 **/

public class TestOptional {
    /**
     * Optional容器类的常用方法:
     * Optional.of(T t) :创建一个 Optional 实例
     * Optional. empty() :创建一个空的 Optional 实例
     * Optional. ofNu1lable(T t):若t不为nu11,创建 Optional 实例,否则创建空实例
     * isPresent() :判断是否包含值
     * orElse(T t) :如果调用对象包含值, 返回该值，否则返回t
     * orElseGet(Supplier s) : 如果调用对象包含值,返回该值，否则返回s获取的值
     * map(Function f):如果有值对其处理，并返回处理后的0ptional,否则返回Optional.empty()
     * flatMap( Function mapper):与map类似，要求返回值必须是Optional
     *
     * @param args
     */
    public static void main(String[] args) {
        Optional<Employee> employee ;

        employee= Optional.of(new Employee());
        System.out.println(employee.get());

//        employee = Optional.of(null);
        // java.lang.NullPointerException
//        System.out.println(employee.get());

//        employee = Optional.empty();
//        // java.util.NoSuchElementException: No value present
//        System.out.println(employee.get());

//        employee = Optional.ofNullable(new Employee());
//        if (employee.isPresent()){
//            System.out.println(employee.get());
//        }
//        employee = Optional.ofNullable(null);
//        Employee employee1 = employee.orElse(new Employee("张三", 18, 999.2, Employee.Status.BUSY));
//        System.out.println(employee1);
//
//        employee.orElseGet(()->new Employee());

        // ----------------------------------
//        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 999.2, Employee.Status.BUSY));
//        Optional<String> s = op.map(e -> e.getName());
//        System.out.println(s.get());
//
//        Optional<String> s1 = op.flatMap(e -> Optional.of(e.getName()));
//        System.out.println(s1.get());

        // ----------------------------------

//        Man man = new Man();
//        String n = getGodnessName(man);
//        //  java.lang.NullPointerException
//        System.out.println(n);

       Optional<NewMan> op = Optional.ofNullable(new NewMan());
        String godnessName2 = getGodnessName2(op);
        System.out.println(godnessName2);
    }

    // 获取一个男人心中女神的名字
    public static String getGodnessName(Man man){
        if (man!=null){
            if (man.getGodNess()!=null){
                return man.getGodNess().getName();
            }
        }
        return "null";
    }

    public static String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness())
                .getName();
    }
}