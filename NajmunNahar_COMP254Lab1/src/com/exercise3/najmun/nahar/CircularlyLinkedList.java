package com.exercise3.najmun.nahar;
/* Name  : Najmun Nahar
 * ID    : 301160081
 * Course: COMP-254
 */
public class CircularlyLinkedList<E> {
  //---------------- nested Node class ----------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;     // an element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;  // a reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
 } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList
  /** The designated cursor of the list */
  private Node<E> tail = null;                  // we store tail (but not head)

  /** Number of nodes in the list */
  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList() { }             // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return tail.getNext().getElement();         // the head is *after* the tail
  }

  /**
   * Returns (but does not remove) the last element of the list
   * @return element at the back of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Rotate the first element to the back of the list.
   */
  public void rotate() {         // rotate the first element to the back of the list
    if (tail != null)                // if empty, do nothing
      tail = tail.getNext();         // the old head becomes the new tail
  }

  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    if (size == 0) {
      tail = new Node<>(e, null);
      tail.setNext(tail);                     // link to itself circularly
    } else {
      Node<E> newest = new Node<>(e, tail.getNext());
      tail.setNext(newest);
    }
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) { // adds element e to the end of the list
    addFirst(e);             // insert new element at front of list
    tail = tail.getNext();   // now new element becomes the tail
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    Node<E> head = tail.getNext();
    if (head == tail) tail = null;           // must be the only node left
    else tail.setNext(head.getNext());       // removes "head" from the list
    size--;
    return head.getElement();
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    if (tail == null) return "()";
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = tail;
    do {
      walk = walk.getNext();
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
    } while (walk != tail);
    sb.append(")");
    return sb.toString();
  }
  
  public boolean areListsEqual(CircularlyLinkedList<E> list)
  {
	  if (list == null || this.isEmpty()) {
	      return false;
	  }
	  if (list.size() != this.size()) {
	      return false;
	  }
	  
	  //get the first Node
	   Node<E> head1 = this.tail.getNext();
	   E head1First = head1.getElement();
	   Node<E> head2 = list.tail.getNext();
	   
	   int count =0;
	   while (count++ <= list.size()) 
	   {
	      if (head2.getElement().equals(head1First)) {
	        break;
	      }
	      head2 = head2.getNext();
	    }
		count = 0;
		if (head1.getElement().equals(head2.getElement())) 
		{
		      // matching element for the first node of one list is not found
		      while (count++ <= list.size()) 
		      {
		        head2 = head2.getNext();
		        head1 = head1.getNext();

		        if (!head1.getElement().equals(head2.getElement())) {
		          // in sequence element is not same
		          return false;
		        }
		      }
		      return true;
		} 
		else
		{
		      // matching element for the first node of one list is not found
		      return false;
		}
}
  
//main method
  public static void main(String[] args)
  {
	  
	  //(LAX, MSP, ATL, BOS)
	  CircularlyLinkedList<String> circularList = new CircularlyLinkedList<String>();
	  circularList.addFirst("LAX");
	  circularList.addLast("MSP");
	  circularList.addLast("ATL");
	  circularList.addLast("BOS");
	  System.out.println("L1: "+circularList);
	  
	  CircularlyLinkedList<String> circularList2 = new CircularlyLinkedList<String>();
	  circularList2.addFirst("ATL");
	  circularList2.addLast("BOS");
	  circularList2.addLast("LAX");
	  circularList2.addLast("MSP");
	  System.out.println("L2: "+circularList2);
	  
	  CircularlyLinkedList<String> circularList3 = new CircularlyLinkedList<String>();
	  circularList3.addFirst("LAX");
	  circularList3.addLast("ATL");
	  circularList3.addLast("BOS");
	  circularList3.addLast("MSP");
	  System.out.println("L3: "+circularList3);
	  
	  CircularlyLinkedList<String> circularList4 = new CircularlyLinkedList<String>();
	  circularList4.addFirst("LAX");
	  circularList4.addLast("MSP");
	  circularList4.addLast("ATL");
	  System.out.println("L4: "+circularList4);
	    
	  System.out.println("\nAre L1 and L2 equal: "+circularList.areListsEqual(circularList2));	  
	  System.out.println("Are L1 and L3 equal: "+circularList.areListsEqual(circularList3));
	  System.out.println("Are L1 and L4 equal: "+circularList.areListsEqual(circularList4));
	   
  }
}
