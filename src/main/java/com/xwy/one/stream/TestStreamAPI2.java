package com.xwy.one.stream;

import com.xwy.one.bean.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @date 2021年05月22日08:26:19
 * @author kinna
 *         <p>
 *         Stream的中间操作 多个中间操作可以连接起来形成一个流水线，除非流水 线上触发终止操作，否则中间操作不会执行任何的处理!
 *         而在终止操作时一次性全部处理，称为“惰性求值” 。
 */
public class TestStreamAPI2 {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("张三", 11, 9999.11), new Employee("李四", 22, 8888.00),
				new Employee("王五", 34, 77777.22), new Employee("赵六", 44, 3333.22), 
				new Employee("王八", 34, 6666.22),new Employee("田七", 55, 3333.11));
		/*
		 * 篩迭与切片 : filter-接收Lambda，从流中排除某些元素。
		 * 
		 * limit -截断流， 使其元素不超过給定数量。
		 * 
		 * skip(n)一跳辻元素， 返回一个拐掉了前n个元素的流。若流中元素不足n个，則返回一个空流。与1imit(n)互朴 distinct篩迭，
		 * 通过流所生成元素的hashCode()和equals()去除重夏元素
		 */

		// 内部迭代：迭代操作由 Stream API 完成
		// 中间操作，不会执行任何操作，只有执行终止操作才会执行中间操作
		System.out.println("--------------内部迭代--------------------");
		Stream<Employee> stream = employees.stream().filter(e -> {
//			System.out.println("Stream 流的中间操作");
			return e.getAge() > 30;
		});
		// 终止操作：一次性执行全部内容，即“惰性求值”
		stream.forEach(System.out::println);

		System.out.println("---------------外部迭代-------------------");
		// 外部迭代
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("-------------------------limit-------------------------");
		employees.stream().filter(e -> e.getSalary() > 7000).limit(3).forEach(System.out::println);

		System.out.println("------------------------skip------------------");
		employees.stream().filter(e -> e.getSalary() > 7000).skip(1).forEach(System.out::println);

		/*
		 * 映射 map-接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数， 该函数会被应用到每个元素上,并将其映射成一个新的元素。
		 * flatMap-接收一个函数作为参数,将流中的每个值都换成另-个流,然后把所有流连接成- -个流
		 */

		System.out.println("-----------------------map 映射---------------------------------");
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		list.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
		System.out.println();
		employees.stream().map(Employee::getName).forEach(System.out::print);
		System.out.println();
		Stream<Stream<Character>> map = list.stream().map(TestStreamAPI2::filterCharacter);
		map.forEach((sm) -> {
			sm.forEach(System.out::print);
		});

		System.out.println("------------------------ flatMap   ------------------------");
		System.out.println("------------------------ 排序   ------------------------");
		List<String> list2 = Arrays.asList("cccc", "aaa", "eeee", "rrrrrrrrrrrr", "ffffffffff");
		list2.stream().sorted().forEach(System.out::print);
		System.out.println();

		employees.stream().sorted((e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -e1.getName().compareTo(e2.getName());
			}
		}).forEach(System.out::println);;
	}

	private static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
}
