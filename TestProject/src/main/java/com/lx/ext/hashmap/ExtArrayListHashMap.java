package com.lx.ext.hashmap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExtArrayListHashMap<Key, Value> {

	// map容 量
	private List<Entry<Key, Value>> tables = new ArrayList<Entry<Key, Value>>();
//map的实际容量
	private int size;

	public void put(Key key, Value value) {
		Entry<Key, Value> entry2 = getEntry(key);
		if (entry2 != null) {
			entry2.value = value;

		} else {
			Entry<Key, Value> entry = new Entry<Key, Value>(key, value);
			tables.add(entry);
		}

	}

	public Value get(Key key) {
		Entry<Key, Value> entry = getEntry(key);
		return entry == null ? null : entry.value;
	}

	public Entry<Key, Value> getEntry(Key key) {
		for (Entry<Key, Value> e : tables) {
			if (e.key.equals(key)) {
				return e;
			}

		}

		return null;
	}

	public static void main(String[] args) {
		/*
		 * ExtArrayListHashMap<String, String> hashmap = new ExtArrayListHashMap<String,
		 * String>();
		 * 
		 * hashmap.put("a", "aaaa"); hashmap.put("b", "bbbb"); hashmap.put("a",
		 * "ddddd");
		 */

		/*
		 * LinkedList<String> linkList = new LinkedList<String>(); linkList.add("22");
		 * String s = "a"; String ss = "aaa";
		 * 
		 * System.out.println(s.hashCode()); System.out.println(ss.hashCode());
		 */

		// System.arraycopy(src, srcPos, dest, destPos, length);

		File dir = new File("d:\\test_dir");
		judeDirExists(dir);

	}

	// 判断文件夹是否存在
	public static void judeDirExists(File file) {

		if (file.exists()) {
			if (file.isDirectory()) {
				System.out.println("dir exists");
			} else {
				System.out.println("the same name file exists, can not create dir");
			}
		} else {
			System.out.println("dir not exists, create it ...");
			file.mkdir();
		}

	}

}

class Entry<Key, Value> {
//键
	Key key;
	Value value;

	public Entry(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
}