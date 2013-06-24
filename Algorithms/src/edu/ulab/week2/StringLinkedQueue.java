package edu.ulab.week2;

public class StringLinkedQueue {
	Node first,last;
	 class Node{
		String item;
		Node next;
	}
	public Boolean isEmpty(){
		return first==null;
	}
	public void enQueue(String newItem){
		Node oldLast=last;
		last=new Node();
		last.item=newItem;
		last.next=null;
		if(isEmpty())
			first=last;
		else
			oldLast.next=last;
	}
	public String deQueue(){
		String item=first.item;
		first=first.next;
		if (isEmpty()) last = null;
		return item;
	}
}
