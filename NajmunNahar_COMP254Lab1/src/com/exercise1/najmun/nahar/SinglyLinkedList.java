package com.exercise1.najmun.nahar;

import java.util.Scanner;
/* Name  : Najmun Nahar
 * ID    : 301160081
 * Course: COMP-254
 */
public class SinglyLinkedList<E> implements Cloneable {

	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// Accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Modifier methods
		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}

	} // ----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node<E> head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node<E> tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	/** Constructs an initially empty list. */
	public SinglyLinkedList() {
	} // constructs an initially empty list

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() { // returns (but does not remove) the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() { // returns (but does not remove) the last element
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) { // adds element e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0)
			tail = head; // special case: new node becomes tail also
		size++;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) { // adds element e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty())
			head = newest; // special case: previously empty list
		else
			tail.setNext(newest); // new node after existing tail
		tail = newest; // new node becomes the tail
		size++;
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() { // removes and returns the first element
		if (isEmpty())
			return null; // nothing to remove
		E answer = head.getElement();
		head = head.getNext(); // will become null if list had only one node
		size--;
		if (size == 0)
			tail = null; // special case as list is now empty
		return answer;
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = head;
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}
	public void swapTwoNodes(String node1, String node2){
		
		//CASE-l: node1 and node2 are same
		if( node1 .equals(node2)){
			System. out. println("Both nodes are the same. No swap performed");
			return;
		}		 
		Node<E> previousNode1=null;
		Node<E> currentNode1=head ;
		 
		Node<E> previousNode2= null;
		Node<E> currentNode2=head;

		//Traverse the list to find node1
		while(currentNode1 !=  null &&  !currentNode1.getElement().equals(node1)){
			previousNode1=currentNode1;
			currentNode1 = currentNode1.getNext();
		}

		//Traverse the list to find node2
		while(currentNode2 !=  null &&   !currentNode2.getElement().equals(node2)){
			previousNode2=currentNode2;
			currentNode2 = currentNode2.getNext();
		}

		//CASE-2:Check if either node 1 or node 2 is not present
		if(currentNode1 == null || currentNode2 == null){
			System .out.println("One of the node is missing! No swap performed");
			return;
		}		 

		//CASE-3 : either node 1 or node2 can be head node
		if(previousNode1 == null){
			head = currentNode2; 
		}
		else {
			previousNode1.setNext(currentNode2); 
		}
		
		if(previousNode2 == null){
			head = currentNode1; 
		}
		else {
		previousNode2.setNext(currentNode1); 
		}

		//CASE-4: Either node 1 or node 2 can be tail node
		if(currentNode2.getNext() == null){
			tail = currentNode1;
		}
		else if (currentNode1.getNext()== null){
			tail = currentNode2;
		}

		//CASE 5: Everything working. Perform Swap
		Node<E> temp = currentNode1.getNext(); 
		currentNode1.setNext(currentNode2.getNext()); 
		currentNode2.setNext(temp);
	}

	// main method
	public static void main(String[] args) {

		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("LAX");
		list.addLast("MSP");
		list.addLast("ATL");
		list.addLast("BOS");
		System.out.println("Original List: "+list);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first element to be swapped: ");
		String swapNode1 = scan.nextLine();

		System.out.println("Enter the second element to be swapped:");
		String swapNode2 = scan.nextLine();

		list.swapTwoNodes(swapNode1 ,swapNode2 );
		System.out.println("Swapped List: "+list);
	}

}
