package com.assignment3;
/*
 * Author: Najmun Nahar
 * COMP-254
 * Assignment-3
 * Exercise-1
 */
import java.util.Scanner;

public class Exercise1 {

	public static void printStars(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException();		//argument must be non-negative
		} else if (n == 0) {
			return;										//base case
		} else {
			System.out.print("* ");
			printStars(n - 1);							//recursive case
		}
	}

	public static void upperPattern(int n, int num) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException();		//argument must be non-negative
		} else if (n == 0) {
			return;										//base case
		} else {
			printStars(num - n + 1);		
			System.out.println();
			upperPattern(n - 1, num);					//recursive case
		}
	}

	public static void lowerPattern(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException();		//argument must be non-negative
		} else if (n == 0) {
			return;										//base case
		} else {
			printStars(n - 1);
			System.out.println();
			lowerPattern(n - 1);						//recursive case
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of asterisks of the maximun line: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		upperPattern(num, num);
		lowerPattern(num);

	}

}
