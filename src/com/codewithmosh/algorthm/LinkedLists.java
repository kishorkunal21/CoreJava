package com.codewithmosh.algorthm;

import java.util.ArrayList;

public class LinkedLists {
	private Node first;
	private Node last;
	private Node newNode;
	private ArrayList<Node> nodeList=new ArrayList<Node>();
	
	public void addfirst(int value) {
		first = new Node();
		first.setValue(value);		
		first.setNext(first);
		nodeList.add(first);
		
	}
	public void addlast(int value) {
		
		int i = nodeList.size();
		newNode = new Node();
		nodeList.get((i-1)).setNext(newNode);
		newNode.setValue(value);
		nodeList.add(newNode);
		
	}
	public void remove(int value) {
		
		int nodeSize=nodeList.size();
		for(int i=0;i<nodeList.size();i++) {
			
			if((i==0 || i==(nodeSize-1)) && nodeList.get(i).getValue()==value) {
				nodeList.remove(i);
				break;
			}
			else if(nodeList.get(i).getValue()==value ){
				for(int j=i;j<nodeSize;j++)
				{
					nodeList.set(j,nodeList.get(i+1));
				}
				nodeList.remove((nodeSize-1));
				break;
			}
		}	
	}
	public void printList() {
			for(Node n :nodeList) {
				System.out.println(n.getValue()+" | "+n.getNext());
			}
	}

}
