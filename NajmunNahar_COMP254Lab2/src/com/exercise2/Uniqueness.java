package com.exercise2;

/*
 * Name: Najmun Nahar
 * ID: 301160081
 * Course: COMP-254
 * Lab Assignment-2
 */

import java.util.Arrays;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }
  
  public static void main(String[] args) {
	  
	  int n = 2000;				//initial starting value of n
	  int arraySize = 10;		
	  long finishTime = 60000; 	//1 minute is 60000 milliseconds
	  int[] array = new int[arraySize];   //create array 
	  long[] unique1Elapsed = new long[arraySize]; //array to store elapsed time for unique1 method
	  long[] unique2Elapsed = new long[arraySize]; //array to store elapsed time for unique2 method
	  
	  
	  for(int i = 0; i < arraySize; i++) {
		  array[i] = n;
		  n *= 2; 			//increment the array twice its size
	  }	  
	  	  
	  System.out.println("\nTesting unique2 method:\n");
	  for (int i=0; i < arraySize; i++) {

		  int nSize = array[i];
		  int inputArray[] = arrayToPass(nSize);
		  
		  //Experimental analysis
		  long startTime = System.currentTimeMillis();
		  unique2(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println("n: "+nSize+" size took\t"+elapsed+" ms");
		  
		  //Store elapsed time
		  unique2Elapsed[i] = elapsed;
	  }
	  
	  int unique1maxN = 0; 
	  int unique2maxN = 0; 
	  
	  //variables for conducting binary search
	  int first = 0;
	  int last = array.length-1;
	  int mid = 0;
	  
	  //Binary Search to find maximum n
	  while (first <= last) {
		  mid = (first + last) / 2;

		  if (finishTime < unique2Elapsed[mid]) {
			  // recur left of the middle
			  last = mid - 1;
			  unique2maxN = array[last];
		  }  
		  else if (finishTime > unique2Elapsed[mid]) {
			  // recur right of the middle
			  first = mid + 1;
			  unique2maxN = array[last];
		  } else {
			// found a match
			  unique2maxN = array[mid];
			  break;
		  } 
	  }
	  
	  System.out.println("Unique 2 method maximum effective size before 60000ms is: " + unique2maxN);
	  
	  System.out.println("\nTesting unique1 method:\n");
	  for (int i=0; i < arraySize; i++) {

		  int nSize = array[i];
		  int inputArray[] = arrayToPass(nSize);
		  	  
		  // Experimental analysis
		  long startTime = System.currentTimeMillis();
		  unique1(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println("n: "+nSize+" size took\t"+elapsed+" ms");
		  
		// Store elapsed time
		  unique1Elapsed[i] = elapsed;
	  }
	  
	  // reset points
	  first = 0;
	  last = array.length -1;
	  mid = 0;
	  
	  //binary search to find maximum n 
	  while (first <= last) {
		  mid = (first + last) / 2;

		  if (finishTime < unique1Elapsed[mid]) {
			  // recur left of the middle
			  last = mid - 1;
			  unique1maxN = array[last];
		  }  else if (finishTime > unique1Elapsed[mid]) {
			  // recur right of the middle
			  first = mid + 1;
			  unique1maxN = array[last];
		  } else {
			  // found a match
			  unique1maxN = array[mid];
			  break;
		  } 
	  }
	  
	  System.out.println("Unique 1 method maximum effective size before 60000ms is: " + unique1maxN);
  }
  

  public static int[] arrayToPass(int n) {
	  int arrayToPass[] = new int[n];
	  int numValue = 0;

	  for (int i = 0; i < n; i++) {
		  numValue += 2;
		  arrayToPass[i] = numValue;
	  }

	  return arrayToPass;
  }
}


