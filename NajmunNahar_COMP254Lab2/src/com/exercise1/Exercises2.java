package com.exercise1;
/*
 * Name: Najmun Nahar
 * ID: 301160081
 * Course: COMP-254
 * Lab Assignment-2
 */
public class Exercises2 {

	/** Returns the sum of the integers in given array. */
	
	/**
	 * running time is: O(n)
	 * line 18 has one constant time so its O(1)
	 * line 19  with loop from 1 to n will run O(n) since it is dependent on input size
	 * line 20 has two constant time so its O(1)
	 * line 21 will have O(1)
	 * regardless of the number of constant operations in a line it will equate to O(1)
	 * Stripping out constants and identifying the highest term:
	 * Big O Characterization is O(1) + (O(n) x O(1)) + O(1) = O(n)
	 */
	public static int example1(int n) {
		int sum = 0;
	    for (int i=1; i <= n; i++)       
	      sum += i;
	    return sum;
	}
	
	/**
	 * running time is: O(n)
	 * line 35 has one constant time so its O(1)
	 * line 36  with loop from 1 to 2n will run O(n) since it is dependent on input size
	 * line 37 has two constant time so its O(1)
	 * line 38 will have O(1)
	 * regardless of the number of constant operations in a line it will equate to O(1)
	 * Stripping out constants and identifying the highest term:
	 * Big O Characterization is O(1) + (O(n) x O(1)) + O(1) = O(n)
	 */
	public static int example2(int n) {
	    int p = 1;
	    for (int i=1; i <= 2*n; i++)       
	      p *= i;
	    return p;
	}
	
	/**
	 * running time is: O(n^2)
	 * line 52 has one constant time so its O(1)
	 * line 53  with loop from 1 to n^2 will run O(n^2) since it is dependent on input size
	 * line 54 has two constant time so its O(1)
	 * line 55 will have O(1)
	 * regardless of the number of constant operations in a line it will equate to O(1)
	 * Stripping out constants and identifying the highest term:
	 * Big O Characterization is O(1) + (O(n^2) x O(1)) + O(1) = O(n^2)
	 */
	public static int example3(int n) {
	    int p = 1;
	    for (int i=1; i <= Math.pow(n,2); i++)       
	      p *= i;
	    return p;
	}
	
  
	/**
	 * running time is: O(n^2)
	 * line 71 has one constant time so its O(1)
	 * line 72  with loop from 1 to 2n will run O(n) since it is dependent on input size
	 * line 74  with loop from 1 to i will run O(n) since it is dependent on input size
	 * line 75 has two constant time so its O(1)
	 * line 78 will have O(1)
	 * regardless of the number of constant operations in a line it will equate to O(1)
	 * Stripping out constants and identifying the highest term:
	 * Big O Characterization is O(1) + (O(n) x O(n) x O(1)) + O(1) = O(n^2)
	 */
	public static int example4(int n) {
	    int sum = 0;
	    for (int i=1; i <= 2*n; i++)
	    {
	    	for(int j=1;j<=i; j++)
	    		sum +=i;
	    }
	    	
	    return sum;
	}
	
	
	/**
	 * running time is: O(n^4)
	 * line 94 has one constant time so its O(1)
	 * line 95  with loop from 1 to n^2 will run O(n^2) since it is dependent on input size
	 * line 97  with loop from 1 to i will run O(n^2) since it is dependent on input size
	 * line 98 has two constant time so its O(1)
	 * line 101 will have O(1)
	 * regardless of the number of constant operations in a line it will equate to O(1)
	 * Stripping out constants and identifying the highest term:
	 * Big O Characterization is O(1) + (O(n^2) x O(n^2) x O(1)) + O(1) = O(n^4)
	 */
	public static int example5(int n) {
	    int sum = 0;
	    for (int i=1; i <= Math.pow(n,2); i++)
	    {
	    	for(int j=1;j<=i; j++)
	    		sum +=i;
	    }
	    	
	    return sum;
	}
}

