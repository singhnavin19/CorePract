package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vd4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[ac]");
		Matcher m = p.matcher("ababbab");
		while (m.find()) {
			System.out.println(m.start() + ".." + m.end());
		}

	}

}
