package com.thread;

public class DemoRunnable implements Runnable {

	String demo;

	public DemoRunnable(String demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {

		System.out.println(demo);

	}

	public static void main(String args[]) {
		System.out.println("main");
		DemoRunnable r = new DemoRunnable("Navin Singh");
		Thread t = new Thread(r);
		t.start();

	}
}
