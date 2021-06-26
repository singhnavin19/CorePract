package com.methodreference;

import java.util.Arrays;
import java.util.List;

public class OneArgumentMethodReference {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 10, 3);

		numbers.forEach(System.out::println);
		//		numbers.forEach(OneArgumentMethodReference::myPrint);
		//		numbers.stream().forEachOrdered(s -> System.out.println(s));
	}

	public static int myPrint(Integer no) {
		System.out.println(no);
		return no;
	}
}
