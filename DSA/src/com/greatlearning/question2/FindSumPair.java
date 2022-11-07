package com.greatlearning.question2;

import java.util.HashSet;

public class FindSumPair {
	
	//class for BST node
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		
		// Parameterized constructor 
		public TreeNode(int data) {
			this.key = data;
			this.left = this.right = null;
		}
	};
	
	//method to insert data into the BST
	private static TreeNode insertTreeNode(TreeNode root, int data) {
		//base terminal condition
		if(root == null) {
			return new TreeNode(data);
		}
		if(root.key > data) {
			root.left = insertTreeNode(root.left, data);
		}else if(root.key < data) {
			root.right = insertTreeNode(root.right, data);
		}else {
			System.out.println("Value "+data+" already exists in BST");
			return root;
		}
		return root;		
	}
	
	public static void main(String[] args) {
		//object root of type TreeNode
		TreeNode root = null;
		
		//data to be inserted into BST
		root = insertTreeNode(root,40);
		root = insertTreeNode(root,20);
		root = insertTreeNode(root,60);
		root = insertTreeNode(root,10);
		root = insertTreeNode(root,30);
		root = insertTreeNode(root,50);
		root = insertTreeNode(root,70);
		
		int sum = 130; 		
		boolean result = findSumPair(root,sum);
		
		if(!result) {
			System.out.println("No Such pair Exists");
		}
	}
	
	private static boolean findSumPair(TreeNode root, int sum) {
		HashSet<Integer> data = new HashSet<Integer>();
		return isPairExists(root,data,sum);
	}

	private static boolean isPairExists(TreeNode root, HashSet<Integer> data, int sum) {
		// Base terminal condition
		if(root == null)
			return false;
		
		int comp = sum - root.key;
		
		if(data.contains(comp)) {
			System.out.println("The sum pair exists for the sum "+sum+" : "+ root.key+ " & "+ comp);
			return true;
		}else {
			data.add(root.key);
		}
		
		return isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);
	}

}
