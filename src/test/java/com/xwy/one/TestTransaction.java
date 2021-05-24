package com.xwy.one;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.xwy.one.bean.Trader;
import com.xwy.one.bean.Transaction;

/**
 * @Date 2021年05月23日22:26:45
 * @author kinna
 *
 */
public class TestTransaction {
	public static void main(String[] args) {

		Trader xxxx = new Trader("xxxx", "Cambri");
		Trader yyy = new Trader("yyy", "Milan");
		Trader alan = new Trader("alan", "Cambri");
		Trader nrian = new Trader("nrian", "Cambri");

		List<Transaction> transactions = Arrays.asList(new Transaction(xxxx, 2001, 300),
				new Transaction(yyy, 2012, 3000), new Transaction(alan, 2011, 400), new Transaction(nrian, 2012, 710));

		// 1.找出2011年发生的所有交易，并按交易额排序(从低到高)
		transactions.stream().filter(t -> t.getYear() >= 2001)
				.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).forEach(System.out::println);

		// 2. 交易员都在哪些不同的城市工作过?
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

		// 3.查找所有来自剑桥的交易员，并按姓名排序。
		System.out.println("3.查找所有来自剑桥的交易员，并按姓名排序。");
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambri")).map(t -> t.getTrader().getName())
				.sorted((t1, t2) -> t1.compareTo(t2)).forEach(System.out::println);
		System.out.println();

		// 4.返回所有交易员的姓名字符串，按字母顺序排序。
		transactions.stream().map(t -> t.getTrader().getName()).sorted().forEach(System.out::println);
		System.out.println();

		// 5.有没有交易员是在米兰工作的
		boolean anyMatch = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(anyMatch);
		System.out.println();

		// 6.打印生活在剑桥的交易员的所有交易额。
		Optional<Integer> reduce = transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambri"))
				.map(Transaction::getValue).reduce(Integer::sum);
		System.out.println(reduce.get());
		System.out.println();

		// 7.所有交易中，最高的交易额是多少。
		Optional<Integer> max = transactions.stream().map(t -> t.getValue()).max(Integer::compare);
		System.out.println(max.get());
		System.out.println();

		// 8.找到交易额最小的交易。
		Optional<Transaction> min = transactions.stream()
				.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(min.get());
		System.out.println();
	}
}
