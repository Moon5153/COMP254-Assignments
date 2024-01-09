package com.assignment3;
/*
 * Author: Najmun Nahar
 * COMP-254
 * Assignment-3
 * Exercise-2
 */
import java.util.Scanner;

public class Exercise2 {
	
	public static int numOfVowels(String str,int n) {
        if (n==0) {
            return 0;															 //base case
        } else {
        	int num=numOfVowels(str,n-1);										 //recursive case
            char ch = Character.toLowerCase(str.charAt(n-1));   				 //convert character at n-1 th position of the string to lowercase 
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { //check for vowels
                num++;															 //if vowel is found then increment the number
            }        
            return num;         
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scan.nextLine();
        int n=str.length();
        System.out.println("The number of vowels in the string is: "+numOfVowels(str,n));
    }

}
