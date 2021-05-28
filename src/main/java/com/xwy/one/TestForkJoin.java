package com.xwy.one;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @date 2021年05月24日22:50:44
 * @author kinna
 *
 */
public class TestForkJoin {

	public static void main(String[] args) {
		
		Long dataLong = 10000000000L;
		// fork/Join框架
		Instant startInstant = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, dataLong);
		pool.invoke(task);
		Instant endInstant = Instant.now();
		System.out.println("fork/Join框架 耗费：" + Duration.between(startInstant, endInstant).toMillis());
		
		// 普通 for 循环
		startInstant = Instant.now();
		long sum = 0;
		for (long i = 0; i < dataLong; i++) {
			sum+=i;
		}
		endInstant = Instant.now();
		System.out.println("普通 for 循环 耗费：" + Duration.between(startInstant, endInstant).toMillis());
		
		// java8 并行流
		startInstant = Instant.now();
		LongStream.rangeClosed(0, dataLong).parallel().reduce(0,Long::sum);
		endInstant = Instant.now();
		System.out.println("java8 并行流 耗费：" + Duration.between(startInstant, endInstant).toMillis());
		
	}
}
