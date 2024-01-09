package com.exercise2.najmun.nahar;
/**
 * 
 * @author Najmun Nahar
 * ID:301160081
 * Course: COMP-254
 * Lab-05
 * Exercise-2
 *
 */
public class Exercise2 {

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
	
	public static <E> void postOrderWithHeight(AbstractTree<E> T) {
		for (Position<E> p : T.postorder()) {
			System.out.println("Element: " + p.getElement() + ", Height = " + T.height(p));
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

		// children of F
		Position<String> F = lbt.addLeft(C, "F");
		Position<String> G = lbt.addRight(C, "G");

		// children of D
		Position<String> H = lbt.addLeft(E, "H");
		Position<String> I = lbt.addRight(E, "I");

		parenthesize(lbt, A);	
		

		System.out.println("");
		postOrderWithHeight(lbt);
	}


}
