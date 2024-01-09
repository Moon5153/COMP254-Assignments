package com.exercise2.najmun.nahar;
import maps.*;
public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnsortedTableMap<Integer, String> u1 = new UnsortedTableMap<>();
		
		// Populate Map
		u1.put(254, "Data Structures");
		u1.put(308, "Emerging Technologies");
		u1.put(303, "Java EE");
		u1.put(123, "Programming");
		u1.put(210, "Linear Algebra & Statistics");
		
		// Test containsKey
		System.out.println("containsKey of (254): " + u1.containsKey(254));
		System.out.println("containsKey of (308): " + u1.containsKey(308));
		System.out.println("containsKey of (123): " + u1.containsKey(123));
		System.out.println("containsKey of (320): " + u1.containsKey(320));
		System.out.println("containsKey of (125): " + u1.containsKey(125));

	}

}
