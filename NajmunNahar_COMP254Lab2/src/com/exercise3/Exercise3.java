package com.exercise3;
/*
 * Name: Najmun Nahar
 * ID: 301160081
 * Course: COMP-254
 * Lab Assignment-2
 */
public class Exercise3 {
	
	static int getNum(int arrayA[], int n){
        int max = arrayA[0];
        for(int i = 0; i < n; i++){ // single iteration so O(n) time algorithm
            if(arrayA[i]>max)
            {
            	max=arrayA[i];
            }
        }
        return 2*max+1; // result will be 2 times maximum value + 1
    }

	public static void main(String[] args) {
		 int arrayA[] = {1,6,4,2,3,5}; // initializing the array
		 int n=arrayA.length;		   //length of the array
		 System.out.println("Array A: ");
	     for(int i=0;i<n;i++)
	     {
	         System.out.println(arrayA[i]); //print the array
	     }
	     int result=getNum(arrayA,n); //store the number in result
	     System.out.println("The integer that cannot be formed as the sum of two integers in Array A is: "+result); //print the result


	}

}
