package com.xwy.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * mac
 * 
 * @author xuwenyan
 *
 *         Java8 内置的四大核心函数式接口
 * 
 *         Consumer<T> ：消费型接口 void accept(T t);
 *         <p>
 *         Supplier<T> ：供给型接口 T get();
 *         <p>
 *         Function<T,R> ： 函数型接口 R apply(T t);
 *         <p>
 *         Predicate<T> ： 断言型接口 boolean test(T t);
 *         <p>
 */
public class TestLambda3 {
	public static void main(String[] args) {
		System.out.println("---------consumer<T> 消费型接口：----------");
		happy(1000, (m) -> System.out.println("每次花费：" + m + "元"));

		System.out.println("----------Supplier<T> ：供给型接口 T get();------");
		List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
		System.out.println(list);

		System.out.println("------------Function<T,R> ： 函数型接口 R apply(T t);---------");
		String newString = strHandler("\t\t\t  你睡啥。起来嗨 .哈      哈哈     ", str -> str.trim());
		System.out.println(newString);

		newString = strHandler("想问一下信息", str -> str.substring(1, 2));
		System.out.println(newString);

		System.out.println("-------------Predicate<T> ： 断言型接口 boolean test(T t);-------------");
		List<String> list2 = Arrays.asList("Hello", "xwy", "qq", "jj");
		List<String> filterStr = filterStr(list2, s -> s.length() > 2);
		System.out.println(filterStr);

	}

	// 需求：将满足条件的字符串放入集合中
	public static List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> sList = new ArrayList<>();
		for (String string : list) {
			if (pre.test(string)) {
				sList.add(string);
			}
		}
		return sList;
	}

	// 需求：用于处理字符串
	public static String strHandler(String string, Function<String, String> function) {
		return function.apply(string);
	}

	// 需求：产生指定个数的整数，并放入集合中
	public static <Ingeter> List<Ingeter> getNumList(int num, Supplier<Ingeter> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Ingeter n = sup.get();
			list.add((Integer) n);
		}
		return (List<Ingeter>) list;
	}

	public static void happy(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}

}
