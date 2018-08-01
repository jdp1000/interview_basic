package com.atguigu.java;
//创建两个线程，分别打印100以内的偶数和奇数
//判断多个线程是否存在线程的安全问题：是否存在共享数据
public class TestThread {
	public static void main(String[] args) {
		//创建了继承Thread类的匿名类的匿名对象
		new Thread("线程1"){
			public void run(){
				for(int i = 1;i <= 100;i++){
					if(i % 2 == 0){
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
		
		new Thread("线程2"){
			public void run(){
				for(int i = 1;i <= 100;i++){
					if(i % 2 != 0){
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
	}
}
