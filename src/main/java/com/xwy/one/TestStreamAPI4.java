package com.xwy.one;

import com.xwy.one.bean.Employee;
import com.xwy.one.bean.Employee.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @date 2021年05月23日18:39:21
 * @date 2021年05月23日22:05:45
 * @author kinna
 *
 */
public class TestStreamAPI4 {
	public static void main(String[] args) {
		/*
		 * 给定一个数字列表，如何返回一个由每个数的平方构成的 列表？
		 */
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		Arrays.stream(nums).map(x -> x * x).forEach(System.out::print);
		System.out.println();
		/*
		 * 怎样用 map 和 reduce 方法数一数流之后有多少个 Employee
		 */
		List<Employee> employees = Arrays.asList(new Employee("张三", 11, 9999.11, Status.BUSY),
				new Employee("李四", 22, 8888.00, Status.FREE), new Employee("王五", 34, 77777.22, Status.VOCATION),
				new Employee("赵六", 44, 3333.22, Status.VOCATION), new Employee("王八", 34, 6666.22, Status.BUSY),
				new Employee("田七", 55, 3333.11, Status.FREE), new Employee("田七", 35, 8989.11, Status.FREE));

		Optional<Integer> reduce = employees.stream().map(e -> 1).reduce(Integer::sum);
		System.out.println(reduce.get());
	}

}
