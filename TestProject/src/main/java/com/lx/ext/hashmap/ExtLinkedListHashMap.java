package com.lx.ext.hashmap;

import java.util.LinkedList;

public class ExtLinkedListHashMap {

	// 数组的长度
	private static int size = 4;
	// 存放所有map对象
	private static LinkedList<Entry>[] tables = new LinkedList[size];
	//
	private static int totalLength = 0;

	public void put(Object key, Object value) {
		Entry newEntry = new Entry(key, value);
		int hashcode = key.hashCode();// 得到每一个对象的hashcode

		int hash = hashcode % tables.length;// 取余，相当于就找到了这个map存放的数据下标位置

		// 取出该下标的集合
		LinkedList<Entry> linkedList = tables[hash];
		// 如果为空，说明没有出现hash冲突
		if (linkedList == null) {
			totalLength++;
			linkedList = new LinkedList<Entry>();

			linkedList.add(newEntry);
			tables[hash] = linkedList;
			// 反之，出现了hash冲突
		} else {
			// true表示默认未发生冲突
			boolean flag = true;
			for (Entry e : linkedList) {
				//
				if (e.key.equals(key)) {
					e.value = value;
					flag = false;
				}

			}
			if (flag) {
				totalLength++;
				linkedList.add(newEntry);
				tables[hash] = linkedList;
			}

		}
		// map元素个数大于4个，即进行扩容
		if (totalLength > size) {
			resize();
		}
	}

	public void put(LinkedList<Entry>[] tableCopy, Object key, Object value) {
		Entry newEntry = new Entry(key, value);
		int hashcode = key.hashCode();// 得到每一个对象的hashcode

		int hash = hashcode % tableCopy.length;// 取余，相当于就找到了这个map存放的数据下标位置

		// 取出该下标的集合
		LinkedList<Entry> linkedList = tableCopy[hash];
		// 如果为空，说明没有出现hash冲突
		if (linkedList == null) {
			linkedList = new LinkedList<Entry>();

			linkedList.add(newEntry);
			tableCopy[hash] = linkedList;
			// 反之，出现了hash冲突
		} else {
			// true表示默认未发生冲突
			boolean flag = true;
			for (Entry e : linkedList) {
				//
				if (e.key.equals(key)) {
					e.value = value;
					flag = false;
				}

			}
			if (flag) {
				linkedList.add(newEntry);
				tableCopy[hash] = linkedList;
			}

		}

	}

	public Object get(Object key) {
		int hashcode = key.hashCode();// 得到每一个对象的hashcode

		int hash = hashcode % tables.length;// 取余，相当于就找到了这个map存放的数据下标位置
		// 取出该下标的集合
		LinkedList<Entry> linkedList = tables[hash];
		for (Entry e : linkedList) {
			if (e != null && e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}

	public void remove(Object key) {
		int hashcode = key.hashCode();// 得到每一个对象的hashcode

		int hash = hashcode % tables.length;// 取余，相当于就找到了这个map存放的数据下标位置
		LinkedList<Entry> linkedList = tables[hash];
		for (Entry e : linkedList) {
			if (e != null && e.key.equals(key)) {
				linkedList.remove(e);
			}
		}
	}

	public void resize() {
		// 每次扩容，数组长度增加2倍
		size = size << 1;
		LinkedList<Entry>[] tablesCopy = new LinkedList[size];
		// 1.获取现有集合的所有map，重新计算每个key的hashcode,再put
		for (int i = 0; i < tables.length; i++) {
			LinkedList<Entry> linkedList = tables[i];
			if (linkedList != null) {
				for (Entry e : linkedList) {
					if (e != null)
						put(tablesCopy, e.key, e.value);
				}
			}

		}
		tables = tablesCopy;
	}

	public static void main(String[] args) {
		ExtLinkedListHashMap extLinkedListHashMap = new ExtLinkedListHashMap();

		extLinkedListHashMap.put("d", "dddd");
		extLinkedListHashMap.put("e", "eeee");
		extLinkedListHashMap.put("h", "hhhh");
		extLinkedListHashMap.put("a", "aaaa");
		extLinkedListHashMap.put("g", "gggg");
		extLinkedListHashMap.put("a", "cccc");
		extLinkedListHashMap.put("a", "cccccc");
		extLinkedListHashMap.put("k", "kkkk");
		extLinkedListHashMap.put("j", "jjjj");
		extLinkedListHashMap.put("o", "oooo");
		System.out.println(extLinkedListHashMap.get("a"));
		System.out.println(extLinkedListHashMap.get("d"));
		System.out.println(extLinkedListHashMap.get("e"));
		System.out.println(extLinkedListHashMap.get("h"));
		System.out.println(extLinkedListHashMap.get("g"));
		System.out.println(extLinkedListHashMap.get("k"));
		System.out.println(extLinkedListHashMap.get("j"));
		extLinkedListHashMap.remove("o");
		System.out.println(extLinkedListHashMap.get("o"));
		System.out.println(totalLength);
		System.out.println(size);
	}
}
