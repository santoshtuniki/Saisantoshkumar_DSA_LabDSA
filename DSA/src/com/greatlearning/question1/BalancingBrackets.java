package com.greatlearning.question1;

import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		
		String input = "([[{}]])";
		boolean result = isBalancedString(input);
		
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
	
	private static boolean isBalancedString(String input) {  
		//creating a stack
		Stack<Character> temp = new Stack<Character>();
		
		for(int i=0;i<input.length();i++) {			
			// taking a character from the string input
			char ch = input.charAt(i);
			
			// if stack is empty
			if(temp.isEmpty()) {
				if(ch == ')' || ch == '}' || ch == ']') {	// if closed bracket entered before an opening then we conclude its an unbalanced brackets
					return false;
				} else {
					temp.push(ch);
				}
			} 
			// if stack is not empty
			else {
				// see the element at top of the stack
				char top = temp.peek();
				if((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {	// see whether top and the character ch form a pair of matching brackets.
					// if yes, then pop top element
					temp.pop();
				} else if(ch == ')' || ch == '}' || ch == ']') {	// Not a matching but a closed bracket
					return false;
				} else {	// is an opening bracket
					temp.push(ch);
				}
			}
		}
		
		// check if stack is empty after 'for' Loop
		if(temp.isEmpty()) { 
			return true;
		} else {
			return false;	
		}
	}

}
