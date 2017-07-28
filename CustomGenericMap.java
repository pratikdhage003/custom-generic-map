package tasks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap;
import java.util.Collections;

public class CustomGenericMap<Key, Value> extends AbstractMap<Key, Value> {

	private Map<Key, Value> customMap;

	public CustomGenericMap() {
		customMap = new HashMap<>();
	}

	@Override
	public Value get(Object key) {
		return customMap.get(key);
	}

	@Override
	public Value put(Key key, Value value) {
		return customMap.put(key, value);
	}

	@Override
	public Set<Map.Entry<Key, Value>> entrySet() {
		return customMap.entrySet();
	}

	public boolean containsKey(Object key) {
		return customMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return customMap.containsValue(value);
	}

	/* Method for Sorting the map in ascending order on the basis of keys */
	public static <Key extends Comparable, Value extends Comparable> Iterator<Map.Entry<Key, Value>> sortByKeyAsc(
			Map<Key, Value> customMap) {

		List<Map.Entry<Key, Value>> listOfEntries = new LinkedList<Map.Entry<Key, Value>>(customMap.entrySet());

		Collections.sort(listOfEntries, new Comparator<Map.Entry<Key, Value>>() {

			@Override
			public int compare(Entry<Key, Value> o1, Entry<Key, Value> o2) {

				return o1.getKey().compareTo(o2.getKey());
			}
		});

		Map<Key, Value> sortedMap = new LinkedHashMap<Key, Value>();

		for (Map.Entry<Key, Value> entry : listOfEntries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		Iterator<Map.Entry<Key, Value>> iterator = sortedMap.entrySet().iterator();
		
		return iterator;
	}

	/* Method for Sorting the map in descending order on the basis of keys */
	public static <Key extends Comparable, Value extends Comparable> Iterator<Map.Entry<Key, Value>> sortByKeyDesc(
			Map<Key, Value> customMap) {

		List<Map.Entry<Key, Value>> listOfEntries = new LinkedList<Map.Entry<Key, Value>>(customMap.entrySet());

		Collections.sort(listOfEntries, new Comparator<Map.Entry<Key, Value>>() {

			@Override
			public int compare(Entry<Key, Value> o1, Entry<Key, Value> o2) {

				return o2.getKey().compareTo(o1.getKey());
			}
		});

		Map<Key, Value> sortedMap = new LinkedHashMap<Key, Value>();

		for (Map.Entry<Key, Value> entry : listOfEntries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		Iterator<Map.Entry<Key, Value>> iterator = sortedMap.entrySet().iterator();
		new HashSet<>();

		return iterator;
	}

	public static void main(String[] args) {
		CustomGenericMap<String, Integer> stockPrice = new CustomGenericMap<String, Integer>();

		stockPrice.put("Amazon", 150);
		stockPrice.put("Microsoft", 120);
		stockPrice.put("Yahoo", 95);
		stockPrice.put("AT & T", 100);

		/* Printing the keys and values in CustomGenericMap */
		System.out.println("Printing the keys and values in CustomGenericMap \n");
		System.out.println(stockPrice);
		
		/*
		 * Searching an element using containsKey and retrieving the value of
		 * the element using get() method
		 */

		System.out.println("\nIf there exists a key Amazon ? " + stockPrice.containsKey("Amazon"));
		System.out.println("Get the Value for the key Amazon = " + stockPrice.get("Amazon") + "\n");

		/* Sorting in ascending order on the basis of keys */
		Iterator<Map.Entry<String, Integer>> iteratorAsc = sortByKeyAsc(stockPrice);

		System.out.println("\nSorted the stock prices in the ascending order of keys.....\n");

		while (iteratorAsc.hasNext()) {
			System.out.println(iteratorAsc.next());
		}

		/* Sorting in descending order on the basis of keys */
		Iterator<Map.Entry<String, Integer>> iteratorDesc = sortByKeyDesc(stockPrice);

		System.out.println("\nAfter Sorting the stock prices in the descending order of values.....\n");

		while (iteratorDesc.hasNext()) {
			System.out.println(iteratorDesc.next());
		}
	}

}
