package com.exercise3.najmun.nahar;

public class Test {
	 public static void main(String[] args) {		

			LinkedQueue<String> list1 = new LinkedQueue<>();
			LinkedQueue<String> list2 = new LinkedQueue<>();
			
			// Add elements to list1
			list1.enqueue("Mon");
			list1.enqueue("Tue");
			list1.enqueue("Wed"); 

			// Add elements to list2
			list2.enqueue("Thu");
			list2.enqueue("Fri");
			list2.enqueue("Sat");
			list2.enqueue("Sun");

			
			System.out.println("Before Concatenation:");
			System.out.println("List One: " +list1);
			System.out.println("List Two: " +list2);
			
			//Concatenate
			list1.concatenate(list2);
			
			//Print lists post concatenation
			System.out.println();
			System.out.println("Post Concat Process:");
			System.out.println("List One: " +list1);
			System.out.println("List Two: " +list2);

		}
}
