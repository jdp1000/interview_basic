package com.atguigu.java;

/*
 * 经典例题：生产者/消费者问题
 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取
 走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有
 产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 1.是否存在多线程？是！
 2.多个线程分别是什么呢？生产者  消费者
 3.是否存在共享数据？是
 4.共享数据是：产品。需要考虑线程的同步，用来解决线程的安全问题
 5.是否存在线程的通信？是
 */

class Clerk{//店员
	int product;
	
	public synchronized void consumeProduct(){//消费产品
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":消费了第" + product + "个产品");
			product--;
			notifyAll();
		}
	}
	
	public synchronized void addProduct(){//生产产品
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":生产了第" + product + "个产品");
			notifyAll();
		}
	}
}

class Comsumer implements Runnable{//消费者
	Clerk clerk;
	public Comsumer(Clerk clerk){
		this.clerk = clerk;
	}
	@Override
	public void run() {
		System.out.println("消费者开始消费产品");
		while(true){
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
			
		}
	}
}

class Productor implements Runnable{//生产者
	Clerk clerk;
	
	public Productor(Clerk clerk){
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产者开始生产产品");
		while(true){
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.addProduct();
		}
	}
}


public class TestProduct {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor p1 = new Productor(clerk);
		Thread t1 = new Thread(p1);//创建了一个生产者
		Thread t2 = new Thread(p1);
		
		Comsumer c1 = new Comsumer(clerk);
		Thread tt1 = new Thread(c1);//创建了一个消费者
		
		t1.start();
		t2.start();
		tt1.start();
		
	}
}
