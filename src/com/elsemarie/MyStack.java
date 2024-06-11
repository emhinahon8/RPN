package com.elsemarie;

/**
* @author Elsemarie Hinahon
* @date 04/17/2024
* Practicing stacks with 3 operations and linked lists
*/

public class MyStack {
	/**
	 * Instance variable
	 */
	private MyLinkedList list;
	
	/**
	 * Setter
	 */
	public MyStack () {
		this.list = new MyLinkedList();
	}
	
	/**
	 * Adds an item to the top of the stack
	 * @param value The number passed in
	 */
	// This method should call methods in MyLinkedList.
	// For example, inside this method, we expect to see list.addToFront(...)
	public void push(int value) {
		list.addToFront(value);
	}
	
	/**
	 * Removes the top value of a stack, and returns that value
	 * @return front The top value of the stack
	 * @throws Exception
	 */
	public int pop() throws Exception {
		// YOU NEED TO GET THE FRONT VARIABLE AND RETURN IT
		int front = list.lookAtFront();
		list.removeFromFront();
		return front;

		// Look at front, save it to a variable before you delete it .
		// Now you can return "front" even though you removed it.
		// No need for the "list.lookAtFront();" on it's own b/c it doesn't do anything.
	}
	
	/**\
	 * Adds the two numbers of the stack
	 * @param a The first number used in calculation
	 * @param b The second number used in calculation
	 * @return The sum of a and b
	 */
	int add(int a, int b) {
		return a + b;
	}
		
	
	/**
	 * Returns the top value of the stack, without deleting
	 * @return The front value of list
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public int peek() throws Exception {
		return list.lookAtFront();
	}
	
	/**
	 * Returns the list in the form of a string
	 * @return String representation of list
	 */
	@Override 
	public String toString () {
		return this.list.toString();
	}
	
}

