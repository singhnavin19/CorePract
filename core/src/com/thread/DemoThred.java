package com.thread;

public class DemoThred extends Thread {

	String d;

	public DemoThred(String d) {
		super();
		this.d = d;
	}

	@Override
	public void run() {
		System.out.println(d);

	}

	public static void main(String[] args) {

		DemoThred dt = new DemoThred("Navin ");
		dt.start();

	}

}
