package com.xwy.one;

import com.xwy.one.bean.Employee;
import com.xwy.one.bean.Employee.Status;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2021年05月22日09:44:43
 * @author kinna
 *
 */
public class TestStreamAPI3 {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("张三", 11, 9999.11, Status.BUSY),
				new Employee("李四", 22, 8888.00, Status.FREE), new Employee("王五", 34, 77777.22, Status.VOCATION),
				new Employee("赵六", 44, 3333.22, Status.VOCATION), new Employee("王八", 34, 6666.22, Status.BUSY),
				new Employee("田七", 55, 3333.11, Status.FREE), new Employee("田七", 35, 8989.11, Status.FREE));
		/*
		 * 查找与匹配
		 * 
		 * allMatch-检查是否匹配所有元素
		 * 
		 * anyMatch-检查是否至少匹配--个元素
		 * 
		 * noneMatch-检查是否没有匹配所有元素
		 * 
		 * findFirst-返回第一个元素
		 * 
		 * findAny-返回当前流中的任意元素
		 * 
		 * count-返回流中元素的总个数
		 * 
		 * max-返回流中最大值
		 * 
		 * min-返回流中最小值
		 */

		boolean allMatch = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println("------------是否匹配所有元素----------" + allMatch);

		boolean anyMatch = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println("------------是否至少匹配--个元素-------" + anyMatch);

		boolean noneMatch = employees.stream().noneMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println("------------查是否没有匹配所有元素------" + noneMatch);

		Optional<Employee> findFirst = employees.stream()
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
		System.out.println("------------返回排序后的第一个元素-------" + findFirst.get());

		Optional<Employee> findAny = employees.stream().filter(e -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println("------------返回当前流中的任意元素-------" + findAny.get());

		long count = employees.stream().count();
		System.out.println("------------count---------------------" + count);

		Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("-------------max--------------------" + max);

		Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println("--------------min---------------" + min);

		/*
		 * 规约
		 * 
		 * reduce(T identity,BinaryOperatior) / reduce(BinaryOperator)
		 * 可以将流中元素反复结合起来，得到一个值
		 * 
		 * 备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 google 用它来进行玩那个了搜索而出名
		 * 
		 */
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("-------------reduce-------------" + reduce);

		Optional<Double> reduce2 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println("-------------reduce2-------------" + reduce2);

		/*
		 * 收集：
		 * 
		 * collect：将流转换为其他形式， 接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
		 */
		List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
		collect.forEach(System.out::print);

		System.out.println("--------------------上面去重--------------------");
		Set<String> collect2 = employees.stream().map(Employee::getName).collect(Collectors.toSet());
		collect2.forEach(System.out::print);
		System.out.println();

		HashSet<String> collect3 = employees.stream().map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
		collect3.forEach(System.out::print);
		System.out.println();

		Long collect4 = employees.stream().collect(Collectors.counting());
		System.out.println("总条数：" + collect4);

		Double collect5 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("平均值：" + collect5);

		Double collect6 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("工资总和：" + collect6);

		Optional<Employee> collect7 = employees.stream()
				.collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println("最大值：" + collect7);

		Optional<Double> collect8 = employees.stream().map(Employee::getSalary)
				.collect(Collectors.minBy(Double::compare));
		System.out.println("最小值：" + collect8);

		// 分组
		Map<Status, List<Employee>> collect9 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println("分组：");
		System.out.println(collect9);

		// 多级分组
		Map<Status, Map<String, List<Employee>>> collect10 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
					if ((e.getAge() <= 35)) {
						return "青年";
					} else if ((e.getAge() <= 55)) {
						return "中年";
					} else {
						return "老年";
					}
				})));
		System.out.println(collect10);

		DoubleSummaryStatistics collect11 = employees.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("DoubleSummaryStatistics getAverage:" + collect11.getAverage());
		System.out.println("DoubleSummaryStatistics getCount:" + collect11.getCount());
		System.out.println("DoubleSummaryStatistics getMax:" + collect11.getMax());
		System.out.println("DoubleSummaryStatistics getMin:" + collect11.getMin());
		System.out.println("DoubleSummaryStatistics getSum:" + collect11.getSum());

		String collect12 = employees.stream().map(Employee::getName).collect(Collectors.joining(",","---前-- "," ---后---"));
		System.out.println(collect12);
	}
}
