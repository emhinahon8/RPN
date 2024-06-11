package com.elsemarie;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author Elsemarie H
* @date 04/19/2024
* Implementing reverse Polish Notation using stacks
*/
public class RPN {
	
	/**
	 * Asks user for Polish notation expression and uses stacks to print answer
	 * @param args Command line arguments
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	
	public static void main(String[] args) throws Exception {
		// Asks user to input a string
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a reverse Polish notation expression: ");
		
		String notationInput = input.nextLine();
		System.out.println(notationInput);

		String[] elements = notationInput.split(" ");
		System.out.println(Arrays.toString(elements));
		
		
		
		// Creating an instance of MyStack to store numbers
		MyStack numStack = new MyStack();
		for (int i = 0; i < elements.length; i++) {
			String elem = elements[i];
			// Check if elem is a number
			if (isNumeric(elem)) {
	            System.out.println(elem + " is a numeric value."); // TEST print if it's numeric 
	          
				// Convert String to int and push onto stack
				int num = Integer.parseInt(elem);
				numStack.push(num);
				
				
			} else {
				// Handle non-numeric characters (if needed)
				System.out.println(elem + " is NOT NUMERIC value."); // TEST print if it's not numeric
				int num1 = numStack.pop();
				int num2 = numStack.pop();
		
				// Adds the two numbers
				if (elem.equals("+")) {
					numStack.push(num1 + num2);
					 System.out.println(numStack); //TEST print of numStack
				}
				
				// Subtracts the two numbers
				if (elem.equals("-")) {
					numStack.push(num1 - num2 );
					//num1 is 1st # in input, first to be pushed onto stack, first to perform "-", NOT num2
					System.out.println(numStack); //TEST print of numStack
				}
				
				// Multiplies the two numbers
				if (elem.equals("*")) {
					numStack.push(num1 * num2);
				}
				// Divides the two numbers
				if (elem.equals("/")) {
					numStack.push(num1 / num2);
				}
			}
		}
		// Prints the top value of the stack
		System.out.println(numStack.pop());
	}
	
	/**
	 * Checks if a String represents a numeric value
	 * @param str The string passed in
	 * @return True or False
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
