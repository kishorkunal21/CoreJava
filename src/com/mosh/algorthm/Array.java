package com.mosh.algorthm;

public class Array {
	
	private int index=0;
	private static int [] arr = null;
	public Array(int length)
	{
		this.arr = new int[length];
	}
	
	public  void insert(int number)
	{
		int[]  newArr = null;
		System.out.println(index+" "+arr.length);
		//if array is full resize it
		if(arr.length==index)
		{
			newArr = new int[index*2];
			for(int i=0;i<arr.length;i++)
				newArr[i]=arr[i];
			arr= newArr;
		}
		//add new item at the end
		arr[index++]=number;
		
	}
	
	public  void removeAt(int number)
	{
		if(number<=index)
		{
			for(int i =number;i<index;i++)
			{
				arr[i]=arr[i+1];
			}
		}
		index--;
		
	}
	
	public  int indexOf(int number)
	{
		int ind=-1;
		for(int i =0;i<=index;i++)
		{
			if(arr[i]==number)
				ind= i;
		}
		return ind;
		
	}
	public  void print()
	{
		for(int i=0;i<index;i++) {
			System.out.println(arr[i]);
		}
	
	}

}
