package com.exercise2.najmun.nahar;
/*
 * Name: Najmun Nahar
 * Course: COMP-254
 * ID:301160081
 * Exercise-2
 * 
 */
import java.util.Stack;

public class StackRemove {
	
	public static <E> void removeElements(Stack<E> stack) {
		if (stack.isEmpty()) {
			return;				//base case
		}
		else {
			stack.pop();			//remove the top element
			removeElements(stack);  // recursive call
		}
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(); // create Stack of String

		// populate the stack
		stack.push("Mon");
		stack.push("Tue");
		stack.push("Wed");
		stack.push("Thu");
	
		System.out.println("Stack before recursive remove call " + stack);
		removeElements(stack);
		System.out.println("Stack after recursive remove call : " + stack);	

	}
	
	
}
