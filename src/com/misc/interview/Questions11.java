package com.misc.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Questions11 {

	public static void main(String[] args) {

		int[][] arr = new int[2][2];
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[1][0] = 1;
		arr[1][1] = 1;

		// mostFrequent();
		// commonElements();
		// rotationArray();
		// LinkedListNthNode();
	}

	static void LinkedListNthNode() {

		List<Integer> ll = new LinkedList<Integer>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);

		System.out.println(ll.get(3));

	}

	static void rotationArray() {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 5, 4, 3, 2, 1 };

		boolean check = true;

		for (int i = 0; i < array1.length; i++) {
			if (!(array1[i] == array2[(array2.length - 1) - i])) {
				System.out.println("NA");
				check = false;
				break;
			}

		}

		System.out.println(check);
	}

	public static void commonElements() {
		int[] array1 = { 1, 3, 4, 6, 7, 9 };
		int[] array2 = { 1, 3, 2, 4, 5, 9, 0 };
		int p1 = 0;
		int p2 = 0;
		// Need to use ArrayList because we don't know the size of the resulting
		// array yet. Note that an ArrayList is resizable.
		ArrayList<Integer> result = new ArrayList<Integer>();

		while (p1 < array1.length && p2 < array2.length) {
			if (array1[p1] == array2[p2]) {
				result.add(array1[p1]);
				p1 += 1;
				p2 += 1;
			} else if (array1[p1] > array2[p2]) {
				p2 += 1;
			} else {
				p1 += 1;
			}
		}
		System.out.println(result);
	}

	static void commonArray() {
		int[] arr1 = { 1, 3, 4, 6, 7, 9 };
		int[] arr2 = { 1, 3, 2, 4, 5, 9, 0 };
		// System.arraycopy(arr, 0, arg2, arg3, arg4);

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {

			if (i < arr1.length) {
				if (arr1[0] == arr2[0])
					result.add(arr1[0]);
			}

		}

	}

	static void mostFrequent() {
		int[] arr = { 1, 3, 1, 3, 2, 1 };

		int maxCount = 1;
		int maxItem = -1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else
				map.put(i, 1);
			if (map.get(i) > maxCount) {
				maxCount = map.get(i);
				maxItem = i;
			}
		}
		System.out.println(maxItem);

	}

}
