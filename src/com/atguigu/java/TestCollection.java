package com.atguigu.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * �洢��ʽ��1.˳��ṹ 2.��ʽ�洢
 * 
 * 1.���ݵĴ洢�ġ��������������� int[] arr = new int[10]�ڼ���
 * 2.Collection:�����洢һ��һ��������
 * 		|-----Set:�洢����ġ������ظ�������--�൱�ڸ��е�"����"--����ϣ�㷨��
 * 			|----HashSet:��Ҫ��ʵ����
 * 				|----LinkedHashSet:����Ƶ���ı�����Ч�ʸ�
 * 			|----TreeSet:���԰�����ӵ�Ԫ�ص�ָ�����Խ��������������Ȼ����Comparable��compareTo��Object obj����&��������Comparator��compare(Obejct obj1,Object obj2)����
 * 		|-----List:�洢����ġ������ظ�������--�൱��"��̬"����
 * 			|----ArrayList:��Ҫʵ���࣬�̲߳���ȫ��
 * 			|----LinkedList:����Ƶ���Ĳ��롢ɾ��������Ч�ʸ���ArrayList
 * 			|----Vector:���ϵ�ʵ���࣬�̰߳�ȫ��
 * 
 *   Map:�����洢һ��һ�Ե�����(key-value)---�൱��y = f(x). y = x + 1;(x1,y1)(x2,y2)
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
		//ԭ������Զ�����Ķ���Set��ʱ����Ҫ�Զ���������ڵ�����д��equals()��hashCode();
		set.add(new Person("л����",32));
		set.add(new Person("л����",32));
		set.add(new Person("����",23));
		
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

