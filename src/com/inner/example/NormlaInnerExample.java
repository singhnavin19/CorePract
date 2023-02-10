package com.inner.example;

//navin test
public class NormlaInnerExample {

	class InnerExample {
		public void sayHello() {
			System.out.println("I am normal inner");
		}
	}
	public static void main(String[] args) {
		InnerExample i = new NormlaInnerExample().new InnerExample();
		i.sayHello();
	}

}
