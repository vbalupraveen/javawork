package edu.ulab.symboltable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
	private Node root;
	private int noOfCmps = 0;

	private class Node {
		private String key;
		private String value;
		private Node left, right;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node put(Node r, String key, String value) {
		if (r == null)
			return new Node(key, value);
		int cmp = key.compareTo(r.key);
		if (cmp < 0)
			r.left = put(r.left, key, value);
		else if (cmp > 0)
			r.right = put(r.right, key, value);
		else if (cmp == 0)
			r.value = value;
		return r;
	}

	public void put(String key, String value) {
		root = put(root, key, value);
	}

	public String get(String key) {
		Node t = root;
		while (t.key != null) {
			int cmp = key.compareTo(t.key);
			if (t.key == key)
				return t.value;
			else if (cmp < 0)
				t = t.left;
			else if (cmp > 0)
				t = t.right;
			noOfCmps++;
		}
		return null;
	}

	public Iterable<String> keys() {
		LinkedList<String> q = new LinkedList<>();
		inorder(root, q);
		return q;
	}

	private void inorder(Node x, LinkedList<String> q) {
		if (x == null)
			return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}
	
	public void deleteMin(){
		root=deleteMin(root);
	}
	
	private Node deleteMin(Node r){
		if(r.left==null) return r.right;
		else r.left=deleteMin(r.left); 
		return r;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.put("g", "1");
		bst.put("v", "2");
		bst.put("c", "3");
		bst.put("b", "4");
		bst.put("k", "5");
		bst.put("h", "6");
		bst.put("p", "7");
		bst.put("a", "8");
		bst.deleteMin();

		System.out.println("value at key:" + bst.get("p"));
		System.out.println(bst.noOfCmps);
		System.out.println("-all elements-");
		List<String> list = (List<String>) bst.keys();
		Iterator<String> i = list.iterator();
		while (i.hasNext())
			System.out.print(i.next() + "-");

	}
}
