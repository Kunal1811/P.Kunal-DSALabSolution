package com.lab3.balance;

import java.util.Scanner;
import java.util.Stack;

public class balanceBrackets {
	
	static Scanner sc = new Scanner(System.in);
	 
	
	static boolean isBalanced(String str) {
		
		//Function to check for balanced brackets
		
		Stack<Character> stack = new Stack<Character>(); //[{()}]
		
		for(int i=0; i<str.length();i++) {
			
			char x = str.charAt(i);
			
			//If opening brackets are encountered, push them to the stack
			
			if(x=='{' || x=='[' || x=='(') {
				stack.push(x);
				continue;
			}
			
			//Continue if stack isn't empty
			//If closing bracket NOT corresponding to an opening bracket is encountered, return false;
			
			if(stack.isEmpty())
				return false;
			char check;
			switch(x) {
				case ')': 
						check = stack.pop();
						if(check == '{' || check == '[')
							return false;
						break;
				case ']': 
					check = stack.pop();
					if(check == '{' || check == '(')
						return false;
					break;
				case '}': 
					check = stack.pop();
					if(check == '(' || check == '[')
						return false;
					break;
			}
			
		} 
		
		//Return true if stack is empty i.e Expression is balanced!
		return(stack.isEmpty());
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter the string to be balanced: ");
		String bracket = sc.next();
		
		if(isBalanced(bracket))
			System.out.println("The Entered String Has Balanced Brackets!");
		else
			System.out.println("The Entered Strings Do NOT Contain Balanced Brackets");
	}
}
