package com.xwy.one.stream;

import com.xwy.one.bean.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @date 2021年05月22日08:13:49
 * @author kinna
 *
 *         ## Stream 的三个 操作步骤：
 * 
 *         - 1.创建 Stream
 *         <p>
 *         - 2.中间操作
 *         <p>
 *         - 3.终止操作（终端操作）
 *         <p>
 */
public class TestStreamAPI {

	public static void main(String[] args) {
		// 创建 Stream
		// 1.可以通过 Collection 系列集合提供的 Stream() 或 parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();

		// 2. 通过 Arrays 中的静态方法 Stream() 获取数组流
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);

		// 3. 通过 Stream 类之后的静态方法 of()
		Stream<String> stream3 = Stream.of("a", "b", "c");

		// 4. 创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
		stream4.limit(10).forEach(System.out::println);

		System.out.println("----------------------------");
		// 生成
		Stream.generate(() -> (int) Math.random()).limit(5).forEach(System.out::println);

	}
}
