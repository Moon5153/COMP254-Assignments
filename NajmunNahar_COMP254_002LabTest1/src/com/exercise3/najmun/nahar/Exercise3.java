package com.exercise3.najmun.nahar;
/*Name: Najmun Nahar
 * ID: 301160081
 * Exercise1
 */
public class Exercise3 {

public static int[] tenLargest(int[] arr) {
		
		int[] tenLargestElements = new int[10];		
		for (int i = 0; i < arr.length; i++) {
	        for (int j = i + 1; j < arr.length; j++) {
	        	
	            int temp = 0;
	            if (arr[i] > arr[j]) {
	                temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        final int max = 10;
	        for(int j = 0; j < max; j++) {
	        	tenLargestElements[j] = arr[arr.length - (j + 1)];
	        }
		
		}
		return tenLargestElements;
		
	}
	//Running Time = O(n^2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {16,2,3,1,4,5,6,8,7,9,10,12,11,15,13,14};
		int[] tenLargestArray = new int[9];
		tenLargestArray = (tenLargest(a));
		System.out.println("Ten largest elements in array are: ");
		for(int i=0;i<tenLargestArray.length;i++){

			System.out.print(tenLargestArray[i]+" ");
		}
		
	}

}

