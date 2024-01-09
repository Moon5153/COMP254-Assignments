package com.exercise3.najmun.nahar;
/**
 * 
 * @author Najmun Nahar
 * ID:301160081
 * Course: COMP-254
 * Lab-05
 * Exercise-3
 *
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SortedPriorityArray<K,V> extends AbstractPriorityQueue<K,V>  {
	/** empty array list */
	private List<Entry<K, V>> list = new ArrayList<>();

	/** Creates an empty priority queue based on the natural ordering of its keys. */
	public SortedPriorityArray() { super(); }

	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public SortedPriorityArray(Comparator<K> comp) { super(comp); }
	
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		if(list.size()==0) // first item to be added
			list.add(newest);
		else {
			//tries to find appropriate insertion location in the ArrayList
			for (int i = 0; i < list.size(); i++) {
				if (compare(list.get(i), newest) > 0) {
					list.add(i, newest);
					return newest;
				}
			}
			list.add(list.size(), newest);
		}
		return newest;
	}
	@Override
	public Entry<K, V> min() {
		if(list.isEmpty()) return null;
		return list.get(0); //O(1)
	}

	@Override
	public Entry<K, V> removeMin() {
		if(list.isEmpty()) return null;
		return list.remove(0); //O(1) 
	}
	
	/**
	 * Returns the number of items in the priority queue.
	 * @return number of items
	 */
	@Override
	public int size() { return list.size(); }

	public static void main(String args[]) {

		SortedPriorityArray<String, String> sortedArray = new SortedPriorityArray<>();

		sortedArray.insert("6", "A");
		sortedArray.insert("1", "B");
		sortedArray.insert("3", "C");
		sortedArray.insert("4", "D");
		sortedArray.insert("2", "E");
		sortedArray.insert("5", "F");

		
		// list sorted array
		for(Entry<String, String> arrayItem: sortedArray.list) {
			System.out.println( "(" + arrayItem.getKey() + ", " + arrayItem.getValue() + ")" );
		}
		
		// list min value
		System.out.println("Entry with minimal key: (" +sortedArray.min().getKey()+","+sortedArray.min().getValue()+")");


	}

}
