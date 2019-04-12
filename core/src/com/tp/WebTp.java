package com.tp;

public class WebTp {

	public String test(String a, String b) {
		System.out.println("jgfdfgjghfgd");
		return a + b;
	}

	public static void main(String[] args) {
		System.out.println("hell o");
		WebTp sc = new WebTp();
		WebTp sc1 = new WebTp(10);
		sc.test(" 10", "b");
	}

	public WebTp() {
		System.out.println("default");
	}

	public WebTp(int a) {
		System.out.println("para" + a);
	}
}
