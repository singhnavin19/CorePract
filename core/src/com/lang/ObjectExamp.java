package com.lang;

public class ObjectExamp {

	String Fname;
	String Lname;

	public ObjectExamp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjectExamp(String fname, String lname) {
		super();
		Fname = fname;
		Lname = lname;
	}

	@Override
	public boolean equals(Object anobjet) {
		if (this == anobjet) {
			return true;
		}
		if (anobjet instanceof ObjectExamp) {
			return true;
		}

		return false;

	}

	@Override
	public String toString() {
		return "ObjectExamp [" + (Fname != null ? "Fname=" + Fname + ", " : "")
				+ (Lname != null ? "Lname=" + Lname : "") + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectExamp m = new ObjectExamp("Navin", "Singh");
		ObjectExamp m1 = new ObjectExamp("Navin", "Singh");

		System.out.println(m.hashCode());
		System.out.println(m1.hashCode());
		System.out.println(m.equals(m1));
		String s = "navin";
		String s1 = new String("navin");
		System.out.println(s.hashCode() + " jdb " + s1.hashCode());
		System.out.println(s == s1);
		System.out.println(s.equals(m1));

	}

}
