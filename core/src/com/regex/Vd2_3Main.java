package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vd2_3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("a");
		Matcher m = p.matcher("ababbaba");
		while (m.find()) {
			System.out.println(m.start() + ".." + m.end() + ".." + m.group());
		}

	}

}
