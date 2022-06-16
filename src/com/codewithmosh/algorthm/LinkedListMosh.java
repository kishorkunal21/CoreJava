package com.codewithmosh.algorthm;

public class LinkedListMosh {
	private Node first;
	private Node last;
	private Node [] nodes = new Node[4];
	private int size=0;
	//private ArrayList<Node> nodeList=new ArrayList<Node>();
	private class Node {
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			this.value=value;
		}
		

	}
	
	public void addlast(int value) {
		
		Node n1  = new Node(value);
		if(isEmpty())
			first = last = n1;		
		else {
			
			last.next = n1;
			n1.prev = last;
			last=n1;	
		}
		size++;
	}
	public void addfirst(int value) {
		Node n1  = new Node(value);
		if(isEmpty())
			first = last = n1;		
		else {
			n1.next = first;
			n1.prev = first;
			first=n1;	
		}
		size++;
			
	}
	
	public void print() {
		System.out.println("Size"+size);
		Node current=first;
		for(int i=0;i<size;i++) {
			if(current!=null) {
				System.out.println(current.value);
				current =current.next;
			}
		}		
	}
	public void reverse() {
		System.out.println("Size"+size);
		Node reverseFirst=null;
		Node reverseLast=last;
				
		Node current=last;
		for(int i=0;i<size;i++) {
			if(current!=null) {
				System.out.println(current.value);
				current =current.prev;
			}
		}		
	}
	
	public void reverseNodes() {
		//10 -> 20 -> 30	
		//				c     n     b
		
		Node previous = first;
		Node current = first.next;
		
		last = first;
		last.next=null;
		while(current!=null) {
			Node next = current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		first=previous;
	}
	public void reverseNodes1() {
		//10 -> 20 -> 30	
		//				c     n     b
		
		Node swapNode = null;
		Node current = first;
		Node backupNode=null;
		//last = current;
		last=first;
		last.next=null;
		while(current.next!=null) {
			swapNode=current.next;
			
			if(swapNode!=null) { 
				backupNode = swapNode.next; 
			} 
			//current.next=backupNode;
			swapNode.next=current;
			current=swapNode;
			current=backupNode;
			current=backupNode;
			
			first = current;
			
		}
		
		first=current;
		
		
		
	}
	public int indexOf(int value) {
		int index =0;
		Node current=first;
		while(current.next!=null) {
			if(current.value==value)
				return index;
			else {
				current = current.next;
			}
			index++;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	public void remove(int value) {
		/*
		 * 
		 * int nodeSize=nodeList.size(); for(int i=0;i<nodeList.size();i++) {
		 * 
		 * if((i==0 || i==(nodeSize-1)) && nodeList.get(i).getValue()==value) {
		 * nodeList.remove(i); break; } else if(nodeList.get(i).getValue()==value ){
		 * for(int j=i;j<nodeSize;j++) { nodeList.set(j,nodeList.get(i+1)); }
		 * nodeList.remove((nodeSize-1)); break; } }
		 */}

	public void printList() {
		/*
		 * for(Node n :nodeList) { System.out.println(n.getValue()+" | "+n.getNext()); }
		 */}

}
