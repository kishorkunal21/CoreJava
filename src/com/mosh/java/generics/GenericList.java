package com.mosh.java.generics;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{

	private T[] items = (T[]) new Object[10];
	private int count = 0;

	public void add(T val) {
		items[count++] = val;
	}

	public T get(int index) {
		return items[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator(this);
	}
	private class ListIterator implements Iterator<T>{
		GenericList<T> list;
		private int index=0;
		
		public ListIterator(GenericList<T> list) {
			this.list=list;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<list.count;
		}

		@Override
		public T next() {
			
			return list.items[index++];
		}
		
	}

}
