package com.xwy.one;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.xwy.one.bean.Employee;

/**
 * mac
 * 
 * @author xuwenyan
 *
 *         方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用” （可以理解为方法引用是 Lambda
 *         表达式的另外一种表现形式）
 *         <p>
 *         主要有三种语法格式：
 *         <p>
 *         对象::实例方法名
 *         <p>
 *         类::静态方法名
 *         <p>
 *         类::实例方法名
 *         <p>
 *         注意：
 *         <p>
 *         1.Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法列表和返回值类型保持一致
 *         <p>
 *         2.若 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是是立法法的参数时，可以使用ClassName::method
 *         <p>
 *         构造器引用： 格式 ClassName::new 注意：需要调用的构造器列表要与函数式接口中的抽象方法的参数列表保持一致
 *         <p>
 *         数组引用
 * 
 */
public class TestMethodRef {
	public static void main(String[] args) {

		// ----------------------对象::实例方法名----------------------

		PrintStream ps1 = System.out;
		Consumer<String> consumer = x -> ps1.print(x);

		PrintStream pStream = System.out;
		Consumer<String> consumer2 = pStream::println;

		Consumer<String> consumer3 = System.out::println;
		consumer3.accept("aaaaaa");

		// ----------------------类::实例方法名-------------------------

		Employee employee = new Employee();
		Supplier<String> supplier = () -> employee.getName();
		String string = supplier.get();
		System.out.println(string);

		Supplier<Integer> supplier2 = employee::getAge;
		Integer num = supplier2.get();
		System.out.println(num);

		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		BiPredicate<String, String> bp1 = String::equals;

		// ---------------------- 类::静态方法名 ----------------------

		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		Comparator<Integer> comparator2 = Integer::compare;

		// ---------------------- 构造器引用 ----------------------
		Supplier<Employee> supplier3 = () -> new Employee();
		supplier3.get();
		// 构造器引用
		Supplier<Employee> supplier4 = Employee::new;

		// ---------------------- 数组引用 ----------------------
		Function<Integer, String[]> function = x -> new String[x];
		String[] strings = function.apply(10);
		System.out.println(strings.length);

		Function<Integer, String[]> function2 = String[]::new;
		String[] strings2 = function2.apply(20);
		System.out.println(strings2.length);

	}

}
