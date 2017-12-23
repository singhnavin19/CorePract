package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList l = new ArrayList();
		l.add("Navin");
		l.add("Navin");
		l.add(12);
		Collections.sort(l);
		// l.sort(null);
		System.out.println(l);

		Iterator it = l.iterator();
		it.forEachRemaining(null);

		ListIterator itr = l.listIterator();

	}

}
