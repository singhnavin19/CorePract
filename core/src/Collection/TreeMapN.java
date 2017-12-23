package Collection;

import java.util.TreeMap;

public class TreeMapN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TreeMap Start here");

		String s = "abbbbcbdefhgu";
		TreeMap<Character, Integer> t = new TreeMap();
		for (int i = 0; i < (s.length() - 1); i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				if (t.containsValue(s.charAt(i))) {
					t.put(s.charAt(i), t.get(s.charAt(i)));
					System.out.println("same");
				} else {
					t.put(s.charAt(i), 2);
				}
			} else {
				System.out.println("not same");
				t.put(s.charAt(i), 1);
			}

		}
		System.out.println(t);
	}

}
