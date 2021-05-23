package com.xwy.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.xwy.one.bean.Employee;

/**
 * @description:
 * @projectName:Java8
 * @see:com.xwy
 * @author:xwy
 * @createTime:2021/5/18 20:28
 * @version:1.0
 */
public class TestLabmda {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        // Lambda 表达式
        Comparator<Integer> comparator1 = (x,y)->Integer.compare(x,y);

        // --------------------------------------------------

        List<Employee> employees = Arrays.asList(
                new Employee("张三",11,9999.11),
                new Employee("李四",22,8888.00),
                new Employee("王五",34,77777.22),
                new Employee("赵六",44,3333.22),
                new Employee("田七",55,3333.11)
        );
        employees.stream().filter((e)->e.getSalary() >= 6000)
                .forEach(System.out::println);

        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
