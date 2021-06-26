package com.methodreference;

import java.util.Arrays;
import java.util.List;

public class TwoArgumentMethodReference {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30);

		int sum = numbers.stream().reduce(0, (total, e) -> Integer.sum(total, e));
		int sum1 = numbers.stream().reduce(0, Integer::sum);

		System.out.println("'" + sum + "'--'" + sum1 + "'");

	}
}
