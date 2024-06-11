package com.elsemarie;

/**
 * @author Elsemarie Hinahon
 * @date 04/18/2024
 * A class "Code Along" using linked lists (Unit 1C)
 */

public class MyLinkedList {
	
	/**
	 * Instance variable
	 */
	public Node head;
	
	/**
	 * Initializes empty linked list by setting head node to null
	 */
	public MyLinkedList() {
		this.head = null;
	}
	
	/**
	 * Checks if linked list is empty
	 * @return True if head node is "null"
	 */
	public boolean isEmpty() {
		return this.head == null;
	}
	
	/**
	 * Adds a new node to front of linked list
	 * @param value The number being added
	 */
	public void addToFront(int value) {
		// Create a new Node from the value
		Node node = new Node(value);
		
		if (this.isEmpty()) {
			this.head = node;
			// I'm done with this function
			return;
		}
		// Make the new node the head of the list
		Node oldHead = head;
		node.setNext(oldHead);
		this.head = node;
	}
	
	
	/**
	 * Retrieves (or looks at) the first, front value of the list
	 * @return Value of node in front of linked list
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public int lookAtFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cannot look at the front of an empty list.");
		}
		
		//returns datatype of whatever the value of node is
		return this.head.value;  // node has a value "int"
	}
	
	/**
	 * Removes node from front of list if list not empty
	 */
	public void removeFromFront() {
		if(!isEmpty()) {
			this.head = this.head.next; // this.head = the beginning of node
		// point head to beginning of list to next, now that becomes the beginning of list
		// the previous beginning is deleted because of "garbage" method
	}
	}
	
	/**
	 * Adds a new node to the end of linked list
	 * @param value The value being added to the back
	 */
	public void addToBackSlow(int value) { // You need a value!
		// go to end of list then add node to next value of the last value of the list
		
		// Create a new node
		Node node = new Node(value);
		
		// Handle empty case
		if (isEmpty()) {
			this.head = node;
		}
		
		
		// We need to find the back of the list
		// DON'T MESS UP OUR LIST
		Node curr = this.head;
		
		// Note: we know node is at end of list if it returns "null"
		while (curr.next!= null) {  // how to traverse list (the BREAD AND BUTTER)
			curr = curr.next;
		}
		
		// Add our new node to the back's next (use same trick in toString)
		curr.next = node;
	}
	
	/**
	 * Removes the last node (number) at the back of list
	 */
	public void removeFromBackSlow() {
		if (isEmpty()) {
			
			// If list only has one element, set head to "null" to make list empty
			
			// Check if there's only one element in list
			if (this.head.next == null) {
				// Empty the list
				this.head = null;
				return;
			}
			
			// DON'T MESS UP THE LIST
			Node curr = head;
			while (curr.next.next != null) { // if it is null, then this tells us we're on the 2nd last element
				curr = curr.next;
			}
			curr.next = null;
			
		}
	}
	
	/**
	 * Retrieves (or looks at) value of last, back node in the list
	 * @return The value of last node in list
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public int lookAtBack() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cannot look at the back of an ampty list.");
		}
		// Go to the back of the list
		// DON'T MESS UP THE LIST
		Node curr = this.head;
		while (curr.next != null) {
			curr = curr.next;
		}
		return curr.value;
	}
	
	/**
	 * Returns the string representation of the list
	 * @return The list as a string
	 */
	@Override
	public String toString() {
		if (this.isEmpty()) {
			return "[]";
		}
		
		String listRep = "[";
		
		// "Loop" over every element in the list
		// DON'T MESS UP OUR LIST
		Node curr = head;
		while (curr.next != null) {
			// Add the current value to the String
			listRep += curr + ", ";
			// Move up the list
			curr = curr.next;
		}
		// Right now, curr is at the LAST value of the list
		listRep += curr;
		
		listRep += "]";
		return listRep;
	}
	
	/**
	 * Initializes node with given value and sets next value to "null"
	 */
	public class Node {
		/**
		 * Instance variable for 'value'
		 */
		int value;
		
		/**
		 * Instance variable for 'next'
		 */
		Node next;
		
		/**
		 * Initializes a 'Node' object 
		 * @param value The number being passed in
		 */
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
		
		/**
		 * Sets the next node as the new, current node
		 * @param next The next node in the list
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		/**
		 * Converts integer value of node into a string representation
		 * @return Value as a string
		 */
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
}

