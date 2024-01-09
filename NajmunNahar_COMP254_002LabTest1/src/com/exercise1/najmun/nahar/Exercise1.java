package com.exercise1.najmun.nahar;
/*Name: Najmun Nahar
 * ID: 301160081
 * Exercise1
 */

public class Exercise1 {

	public static int findMinNumber(int[] data, int n) {
		if (n == 1) {										//base case
			return data[0];
			}
		else
			return Math.min(data[n-1], findMinNumber(data, n-1));
		}
	
	//Running time = O(n) 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,6,7,8,2,3};
		int n = a.length;
		System.out.println("The minimum element in this array is "+findMinNumber(a, n));
		
	}

}
