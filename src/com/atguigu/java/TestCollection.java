package com.atguigu.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * 存储方式：1.顺序结构 2.链式存储
 * 
 * 1.数据的存储的“容器”：①数组 int[] arr = new int[10]②集合
 * 2.Collection:用来存储一个一个的数据
 * 		|-----Set:存储无序的、不可重复的数据--相当于高中的"集合"--“哈希算法”
 * 			|----HashSet:主要的实现类
 * 				|----LinkedHashSet:对于频繁的遍历，效率高
 * 			|----TreeSet:可以按照添加的元素的指定属性进行排序遍历（自然排序Comparable（compareTo（Object obj））&定制排序Comparator（compare(Obejct obj1,Object obj2)））
 * 		|-----List:存储有序的、可以重复的数据--相当于"动态"数组
 * 			|----ArrayList:主要实现类，线程不安全的
 * 			|----LinkedList:对于频繁的插入、删除操作，效率高于ArrayList
 * 			|----Vector:古老的实现类，线程安全的
 * 
 *   Map:用来存储一对一对的数据(key-value)---相当于y = f(x). y = x + 1;(x1,y1)(x2,y2)
 *   		|----HashMap
 *   			|----LinkedHashMap
 *   		|----TreeMap
 *   		|----Hashtable
 *   			|----Properties
 */
public class TestCollection {

	@Test
	public void test2(){
		Set set = new LinkedHashSet();
		set.add(123);
		set.add("AA");
		set.add("MM");
		set.add("GG");
		set.add("GG");
		//原则：添加自定义类的对象到Set中时，需要自定义对象所在的类重写：equals()且hashCode();
		set.add(new Person("谢霆锋",32));
		set.add(new Person("谢霆锋",32));
		set.add(new Person("王菲",23));
		
		System.out.println(set.toString());
		
	}
	@Test
	public void test1(){
		List list = new ArrayList();
		System.out.println(list.size());//0
		
		list.add("AA");
		list.add(123);
		list.add(123);
		list.add(new Date());
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}

