package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vd5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pa = "//d";
		Pattern p = Pattern.compile(pa);
		Matcher m = p.matcher("skhjj@12bbba");
		while (m.find()) {
			System.out.println(m.start() + "." + m.end() + "." + m.group());
		}

	}

}
