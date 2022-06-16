package com.mosh.algorthm2;

public class Heap {

	private int[] values = new int[1];
	private int size = 0;
	// left = parent*2+1
	// right = parent*2+2
	// parent = (index-1)/2

	public void insert(int value) {
		resiezeArray('I');
		values[size] = value;
		bubbleUp(value);
		size++;
		// bubble up
	}

	public int[] sort() {
		return values;
	}
	public void remove(int value) {

		for (int i = 0; i < values.length; i++) {
			if (values[i] == value)
				values[i] = 0;
			bubbleUp(i, getParentIndex(i));
		}
		resiezeArray('R');
		size--;
		// bubble up
	}
	
	public void remove() {
		values[0] = 0;
		for (int i = 0; i < values.length; i++) {
			bubbleUp(i, getParentIndex(i));
		}
		resiezeArray('R');
		size--;
		// bubble up
	}

	public void printHeap() {
		for (int i = 0; i < values.length; i++)
			System.out.println(
					"[" + i + "]" + values[i] + " :: Parent [" + getParentIndex(i) + "]" + values[getParentIndex(i)]);

	}

	private void bubbleUp(int value) {
		if (size > 0)
			bubbleUp(size, getParentIndex(size));
	}

	private void bubbleUp(int currentIndex, int parentIndex) {

		if (values[currentIndex] > values[parentIndex]) {
			int swap = values[parentIndex];
			values[parentIndex] = values[currentIndex];
			values[currentIndex] = swap;
			if (parentIndex <= 0)
				return;
			else
				bubbleUp(parentIndex, getParentIndex(parentIndex));
		}
	}

	private int getParentIndex(int currentInd) {
		int parentIndex = 0;
		if (currentInd > 0) {
			float currentIndex = currentInd;

			if (((currentIndex - 1) / 2) % 1 >= 0.0) {
				parentIndex = (int) (currentIndex - 1) / 2;
				// System.out.println("Currentindex : [" + currentInd + "]" + values[currentInd]
				// + " is LEFT | Parent : ["
				// + parentIndex + "]" + values[parentIndex]);
			} else if (((currentIndex - 2) / 2) % 1 >= 0.0) {
				parentIndex = (int) (currentIndex - 2) / 2;
				// System.out.println("Currentindex : [" + currentInd + "]" + values[currentInd]
				// + " is RIGHT | Parent : ["
				// + parentIndex + "]" + values[parentIndex]);
			}
		}
		return parentIndex;
	}

	private void resiezeArray(char type) {
		int[] temp = new int[values.length + 1];

		if (type == 'R')
			temp = new int[size];

		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		if (size > 0)
			values = temp;

	}
}
