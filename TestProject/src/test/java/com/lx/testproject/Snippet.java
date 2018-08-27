package com.lx.testproject;

import java.util.ArrayList;
import java.util.List;

public class Snippet {
	public static void main(String[] args) {
		StringBuffer str1 = new StringBuffer("123");
		StringBuffer str2 = new StringBuffer("123");
		System.out.println(str1.toString().equals(str2.toString()));
		System.out.println(str1.toString().hashCode() == str2.toString().hashCode());
		
		Object obj=new Object();
		
		System.out.println(obj.hashCode());
		
		List<Object> list=new ArrayList<Object>();
		list.add("");

	}
}
