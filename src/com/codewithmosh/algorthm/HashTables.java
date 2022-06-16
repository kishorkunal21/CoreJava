package com.codewithmosh.algorthm;

import java.util.LinkedList;

public class HashTables {
	
	private LinkedList<Entry> [] entriesList = new LinkedList[5];
	private class Entry{
		private int key;
		private String value;
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}		
	}
	
	public void put(Integer key, String val) {
		Entry e = new Entry(key, val);
		int index  = hash(key);
		System.out.println(index);
		
		if(entriesList[index]==null)
			entriesList[index] = new LinkedList<HashTables.Entry>();
		for(Entry check :entriesList[index])
		{
			if(check.key==key) {
				check.value=val;
				return;
			}
			else
				entriesList[index].add(e);
		}
		
		
	}
	
	private int hash(int key) {
		return key%entriesList.length;
	}

}
