package Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HasSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Empl> h = new HashSet<Empl>();

		// System.out.println(h.add("Navin"));
		// System.out.println(h.add("Singh"));
		// System.out.println(h.add("Navin"));
		// System.out.println(h.add("null"));
		// System.out.println(h.add(null));
		// System.out.println(h.add(null));
		// System.out.println(h.add("pagal"));
		// System.out.println(h);

		// HashSet<Empl> h1 = new HashSet<Empl>();
		HashMap<Empl, String> h1 = new HashMap<Empl, String>();
		Empl e = new Empl("navin", "1000");
		Empl e1 = new Empl("navin", "1000");
		Empl e2 = new Empl("navin", "1000");
		System.out.println(e1.hashCode() + " Code " + e2.hashCode());
		System.out.println(h1.put(e, "Navin1"));
		System.out.println(h1.put(e1, "Navin2"));
		System.out.println(h1.put(e2, "Navin1"));

		System.out.println(h1.size());
		System.out.println("Hashmap:-" + h1);

		Set s = h1.entrySet();

		Iterator itr_hmap = s.iterator();
		while (itr_hmap.hasNext()) {
			Map.Entry me = (Map.Entry) itr_hmap.next();
			System.out.println("ITr_Hasmap" + me.getValue() + ".." + me.getKey());

		}

		h.add(e);
		h.add(e1);
		h.add(e2);
		Iterator<Empl> itr_Hset = h.iterator();
		while (itr_Hset.hasNext()) {
			System.out.println("itr_Hset....:- " + itr_Hset.next());
		}
		System.out.println("HashSet:- " + h);

		TreeSet t = new TreeSet();
		t.add(e);
		t.add(e1);
		t.add(e2);

		System.out.println("treeset" + t);

	}

}
