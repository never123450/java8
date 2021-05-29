package com.xwy.one;

import java.util.concurrent.RecursiveTask;

/**
 * @Date 2021年05月24日22:43:00
 * @author kinna
 *
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

	private long start;
	private long end;

	private static final long THRESHOLD = 10000;

	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i < end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (start + end) / 2;
			ForkJoinCalculate leftCalculate = new ForkJoinCalculate(start, middle);
			leftCalculate.fork();// 拆分子任务，同时加入线程队列

			ForkJoinCalculate rightCalculate = new ForkJoinCalculate(middle, end);
			rightCalculate.fork();

			return leftCalculate.join() + rightCalculate.join();
		}
	}

}
