package com.mosh.algorthm;

//import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTablesImpl {

	public String searchNonIterative( String input) {
		String result="";
		char[] check = input.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//areenappleg
		for(char c:check) {			
			int count =1;
			if(map.containsKey(c)) {
				count = map.get(c);
				count++;
				map.put(c,count);
			}else {
				map.put(c,count);
			}
		}
		for(char c:check) {
			if(map.get(c)==1) {
				System.out.println("result = "+c);
				return ""+c;
			}
		}		return result;
	}
	
	
	public String firstRepeatChar(String input) {
		String result="";
		char[] check = input.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//areenappleg
		for(char c:check) {			
			int count =1;
			if(map.containsKey(c)) {
				count = map.get(c);
				count++;
				map.put(c,count);
			}else {
				map.put(c,count);
			}
		}
		for(char c:check) {
			if(map.get(c)>1) {
				System.out.println("result = "+c);
				return ""+c;
			}
		}
		return result;
	}
	
	public Character firstRepeatCharSet(String input) {
		Character result=null;
		char[] check = input.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(char c :check) {
			if(set.contains(c)) return c;
			set.add(c);
		}
		return result;
	}
}
