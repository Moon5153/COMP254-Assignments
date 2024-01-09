package com.exercise1.najmun.nahar;
import maps.*;
public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double loadFactor=0.5; 	//user defined loadFactor ex: 0.25,0.5,0.75 ...1.0
		ChainHashMap<Integer, String> chainMap = new ChainHashMap<Integer, String>(10, loadFactor);
		
		chainMap.put(1, "A");
		chainMap.put(2, "B");
		chainMap.put(3, "C");
		chainMap.put(4, "D");
		chainMap.put(5, "E");
	
		// print original values first
		System.out.println("Printing original values:");
		for(Entry<Integer, String> p : chainMap.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		// this will overwrite the original values
		chainMap.put(1, "F");
		chainMap.put(2, "G");
		chainMap.put(3, "H");
		chainMap.put(4, "I");
		chainMap.put(5, "J");
		
		// print the new values after being overwritten
		System.out.println("Printing new values:");
		for(Entry<Integer, String> p : chainMap.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		// Enter new key, chain map will resize
		chainMap.put(6, "K");
		chainMap.put(7, "L");
		chainMap.put(8, "M");
		System.out.println("Printing new List After resizing:");
		for(Entry<Integer, String> p : chainMap.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		
	}

}
