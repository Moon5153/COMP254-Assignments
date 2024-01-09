package com.exercise1.najmun.nahar;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	// ---------------- nested Node class ----------------
	/** Nested static class for a binary tree node. */
	protected static class Node<E> implements Position<E> {
		private E element; // an element stored at this node
		private Node<E> parent; // a reference to the parent node (if any)
		private Node<E> left; // a reference to the left child (if any)
		private Node<E> right; // a reference to the right child (if any)

		/**
		 * Constructs a node with the given element and neighbors.
		 *
		 * @param e          the element to be stored
		 * @param above      reference to a parent node
		 * @param leftChild  reference to a left child node
		 * @param rightChild reference to a right child node
		 */
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}

		// get and set methods
		//
		// accessor methods
		public E getElement() {
			return element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		}

		// update methods
		public void setElement(E e) {
			element = e;
		}

		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}

		public void setLeft(Node<E> leftChild) {
			left = leftChild;
		}

		public void setRight(Node<E> rightChild) {
			right = rightChild;
		}
	} // ----------- end of nested Node class -----------

	/** Factory function to create a new node storing element e. */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}

	// LinkedBinaryTree instance variables
	/** The root of the binary tree */
	protected Node<E> root = null; // root of the tree

	/** The number of nodes in the binary tree */
	private int size = 0; // number of nodes in the tree

	// constructor
	/** Construts an empty binary tree. */
	public LinkedBinaryTree() {
	} // constructs an empty binary tree

	// nonpublic utility
	/**
	 * Verifies that a Position belongs to the appropriate class, and is not one
	 * that has been previously removed. Note that our current implementation does
	 * not actually verify that the position belongs to this particular list
	 * instance.
	 *
	 * @param p a Position (that should belong to this tree)
	 * @return the underlying Node instance for the position
	 * @throws IllegalArgumentException if an invalid position is detected
	 */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods (not already implemented in AbstractBinaryTree)
	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return number of nodes in the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the root Position of the tree (or null if tree is empty).
	 * 
	 * @return root Position of the tree (or null if tree is empty)
	 */
	@Override
	public Position<E> root() {
		return root;
	}

	/**
	 * Returns the Position of p's parent (or null if p is root).
	 *
	 * @param p A valid Position within the tree
	 * @return Position of p's parent (or null if p is root)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	/**
	 * Returns the Position of p's left child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	/**
	 * Returns the Position of p's right child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new Position.
	 *
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Creates a new left child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the left of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p already has a left child
	 */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/**
	 * Creates a new right child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the right of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p already has a right child
	 */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null)
			throw new IllegalArgumentException("p already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/**
	 * Replaces the element at Position p with element e and returns the replaced
	 * element.
	 *
	 * @param p the relevant Position
	 * @param e the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of the
	 * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 an independent tree whose structure becomes the left child of p
	 * @param t2 an independent tree whose structure becomes the right child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p is not a leaf
	 */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (isInternal(p))
			throw new IllegalArgumentException("p must be a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) { // attach t1 as left subtree of node
			t1.root.setParent(node); // the node becomes parent of the root of left subtree
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) { // attach t2 as right subtree of node
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	/**
	 * Removes the node at Position p and replaces it with its child, if any.
	 *
	 * @param p the relevant Position
	 * @return element that was removed
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p has two children.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (numChildren(p) == 2)
			throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null)
			child.setParent(node.getParent()); // child's grandparent becomes its parent
		if (node == root)
			root = child; // child becomes root
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null); // help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node); // our convention for defunct node
		return temp;
	}
	
	/*----------------------EXERCISE-1---------------------------*/

	/*
	 * inorderNext(p)
	 */
	public Position<E> inorderNext(Position<E> pos) {

		// CHECK IF THE POSITION IS INTERNAL AND HAVE RIGHT CHILD
		if (isInternal(pos) && right(pos) != null) {
			pos = right(pos); 

			// FIND THE FIRST OCCURENCE OF THE LEFT LEAF
			while (!isExternal(pos) && left(pos) != null) {
				pos = left(pos);
			}
			return pos;
		} else {
			Node<E> node = validate(parent(pos));
			if (pos == node.left) {
				return node; // RETURN THE PARENT IF POSITION IS LEFT NODE
			} else {
				// LOOP UNTIL THE PARENT OF THE POSITION IS A LEFT CHILD OF A NODE
				while (!(pos == node.left)) {
					pos = node;
					node = node.parent;

					if (node == null) {
						break;
					}
				}
				return node;
			}
		}
	}

	/*
	 * postorderNext(p)
	 */
	public Position<E> postorderNext(Position<E> pos) {
		Node<E> node;

		// CHECK IF POSITION IS INTERNAL
		if (isInternal(pos) && parent(pos) != null) {
			// GET THE PARENT POSITION
			node = validate(parent(pos));
			
			// RETURN THE PARENT NODE IF IT IS ALREADY THE RIGHT NODE
			if (pos == node.right) {
				return node;
			} else {
				if (right(pos) != null) {
					// ACCESS RIGHT SIBLING THEN LOOK FOR THE FIRST OCCURENCE OF LEAF
					pos = right(node);
					while (!isExternal(pos) && left(pos) != null) {
						pos = left(pos);
					}
				} else {
					// IF RIGHT SIBLING IS NULL
					pos = parent(pos);
				}
				return pos;
			}
		} else if (parent(pos) != null) {
			// LEAF
			node = validate(parent(pos));
			if (pos == node.left && right(node) != null) {
				// ACCESS RIGHT SIBLING THEN LOOK FOR THE FIRST OCCURENCE OF A LEAF
				pos = right(node);
				while (!isExternal(pos) && left(pos) != null) {
					pos = left(pos);
				}
				return pos;
			} else
				return node;
		}
		return null;
	}

	public static void main(String[] args) {
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
		
		//parenthesize(lbt, A);

	}

	/** Prints parenthesized representation of subtree of T rooted at p. */
	public static <E> void parenthesize(Tree<E> T, Position<E> p) {
		System.out.print(p.getElement());
		if (T.isInternal(p)) {
			boolean firstTime = true;
			for (Position<E> c : T.children(p)) {
				System.out.print((firstTime ? " (" : ", ")); // determine proper punctuation
				firstTime = false; // any future passes will get comma
				parenthesize(T, c); // recur on child
			}
			System.out.print(")");
		}
	}

	//
	public static <E> void printPreorder(AbstractTree<E> T) {
		for (Position<E> p : T.preorder())
			System.out.println(p.getElement());
	}//

	public static <E> void printPostOrder(AbstractTree<E> T) {
		for (Position<E> p : T.postorder())
			System.out.println(p.getElement());
	}

	public static <E> void printInOrder(AbstractBinaryTree<E> T) {
		for (Position<E> p : T.inorder())
			System.out.println(p.getElement());
	}

} // ----------- end of LinkedBinaryTree class -----------
