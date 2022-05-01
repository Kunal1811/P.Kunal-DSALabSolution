package com.lab3.PairSum;

import java.util.HashSet;
import java.util.Scanner;

public class bstPairSum {
	static Scanner sc = new Scanner(System.in);
	
	static class Node{
		int key;
		Node left;
		Node right;
	}
	
	static Node newNode(int data) {
		Node temp = new Node();
		
		temp.key = data;
		temp.left = null;
		temp.right = null;
		
		return temp;
	}
	
	static Node insertNode(Node root, int key) {
		
		Node newnode = newNode(key);
		
		Node x = root;
		Node curr_parent = null;
		
		while(x!=null) {
			curr_parent = x;
			if(key < x.key)
				x = x.left;
			else if(key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!! ");
				return newnode;
			}
		}
		
		//Root Node
		if(curr_parent == null)
			curr_parent = newnode;
		//Else traverse left
		else if(key < curr_parent.key)
			curr_parent.left = newnode;
		//Else traverse right
		else
			curr_parent.right = newnode;
		
		return curr_parent;
	}
	
	public static void findPair(Node root, int sum) {
		
		//Function that checks if a sum pair exists or not
		
		HashSet<Integer> hash = new HashSet<Integer>();
		
		if(!findPairUtil(root, sum , hash)) {
			System.out.println("Pair nodes not found!");
		}
		return;
	}
	
	public static boolean findPairUtil(Node root, int sum , HashSet<Integer> hash) {
		
		//Function which returns a boolean value = false if a pair doesn't exist for a target sum or true if the given sum exists
		//Use of a HashSet improves the time complexity of the program and achieves the objective in a single traversal
		
		if(root == null)
			return false;
		
		if(findPairUtil(root.left, sum, hash))
			return true;
		
		if(hash.contains(sum - root.key)) {
			System.out.println("Pair nodes are found as: ("+ (sum - root.key) +","+ root.key + ")");
			return true;
		}
		
		else
			hash.add(root.key);
		
		return findPairUtil(root.right, sum , hash);
	}
	
	public static void inorder(Node root) {
		
		//Prints the in-order traversal of the BST
		
		if(root==null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		//Node result = null;
		/*
		String s = " ";
		int value;
		
		System.out.println("Enter how many values to enter: ");
		int num = sc.nextInt();
		
		for(int i = 0 ; i < num; i++) {
		
			System.out.println("Enter keys to be entered in tree: ");
			value = sc.nextInt();
			
			if(root==null)
				root = insertNode(root, value);
			else
				insertNode(root, value);
		}
		
		System.out.println("Binary Tree After Insertion: ");
		inorder(root);
		System.out.println();
		
		 		
		System.out.println("Program exited! ");
		*/
		
		
		root = insertNode(root, 40);
		insertNode(root, 20);
		insertNode(root, 60);
		insertNode(root, 10);
		insertNode(root, 30);
		insertNode(root, 50);
		insertNode(root, 70);
		
		System.out.println("The BST After Insertion: ");
		inorder(root);
		System.out.println();

		int sum = 130;
		
		findPair(root, sum);
		
	}	
}
