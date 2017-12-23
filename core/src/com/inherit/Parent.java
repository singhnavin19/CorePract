package com.inherit;

class Parent {
	// static {
	// System.out.println("Parent Static");
	// }

	public Parent() {
		super();
		System.out.println("Parent Conts");
		// TODO Auto-generated constructor stub
	}

	public static void main(String arg[]) {
		System.out.println("Hello prent main ");
	}

}

class Chiled extends Parent {

	public Chiled() {

		System.out.println("Child conts");
	}

	// static {
	// System.out.println("child static");
	// }

	public void move() {
		System.out.println("child method");
	}

	public static void main(String arg[]) {
		System.out.println("Child Main");
		Parent p = new Chiled();
		((Chiled) p).move();

	}
}
