package com.lang;

import java.util.Map;
import java.util.TreeMap;

public class StrinN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "a,z,z,a,z,b,b,a,c,d,e,f";
		// Arrays.to

		String[] split = s.split(",");
		Map<String, Integer> m = new TreeMap<String, Integer>();

		for (int i = 0; i < split.length; i++) {
			// l.add(split[i]);

			if (m.containsKey(split[i])) {
				m.put(split[i], m.get(split[i]) + 1);
			} else {
				m.put(split[i], 1);
			}

			System.out.println(split[i]);

		}
		System.out.println(m);

	}

}
