package com.exercise1.najmun.nahar;
/**
 * 
 * @author Najmun Nahar
 * ID:301160081
 * Course: COMP-254
 * Lab-05
 * Exercise-1
 *
 */
public class Exercise1 {
	/** Returns a string containing n spaces. */

	public static <E> void printPostOrder(AbstractTree<E> T) {
		for (Position<E> p : T.postorder())
			System.out.println(p.getElement());
	}

	public static <E> void printInOrder(AbstractBinaryTree<E> T) {
		for (Position<E> p : T.inorder())
			System.out.println(p.getElement());
	}

	/** Prints parenthesized representation of subtree of T rooted at p. */
	public static <E> void parenthesize(Tree<E> T, Position<E> p) {
		System.out.print(p.getElement());
		if (T.isInternal(p)) {
			boolean firstTime = true;
			for (Position<E> c : T.children(p)) {
				System.out.print( (firstTime ? " (" : ", ") ); // determine proper punctuation
				firstTime = false;                             // any future passes will get comma
				parenthesize(T, c);                            // recur on child
			}
			System.out.print(")");
		}
	}

	public static void main(String[] args)
	{
		LinkedBinaryTree lbt = new LinkedBinaryTree();
		Position<String> A = lbt.addRoot("A");

		// children of A
		Position<String> B = lbt.addLeft(A, "B");
		Position<String> C = lbt.addRight(A, "C");

		// children of B
		Position<String> D = lbt.addLeft(B, "D");
		Position<String> E = lbt.addRight(B, "E");

		// children of C
		Position<String> F = lbt.addLeft(C, "F");
		Position<String> G = lbt.addRight(C, "G");

		// children of E
		Position<String> H = lbt.addLeft(E, "H");
		Position<String> I = lbt.addRight(E, "I");

		parenthesize(lbt, A);
		
		System.out.println("\nIN ORDER OF TREE:");
		printInOrder(lbt);
		
		Position<String> inOrderNextB = lbt.inorderNext(B);
		if (inOrderNextB != null) {
			System.out.println("inorderNext(B): " + inOrderNextB.getElement()); // should return H
		} else {
			System.out.println("inorderNext(B): null, this is the last node");
		}
		
		System.out.println("\nPOST ORDER OF TREE:");
		printPostOrder(lbt);
		
		Position<String> postOrderNextB = lbt.postorderNext(B);
		if (postOrderNextB != null) {
			System.out.println("postorderNext(B): " + postOrderNextB.getElement()); // should return F
		} else {
			System.out.println("postorderNext(B): null, this is the last node");
		}
		
		System.out.println("\nThe worst case running times for inorderNext(p) and postorderNext(p) methods are O(logn) where n is the height of the tree T");
		

	}
}
