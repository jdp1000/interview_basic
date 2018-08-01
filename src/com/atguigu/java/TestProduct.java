package com.atguigu.java;

/*
 * �������⣺������/����������
 ������(Productor)����Ʒ������Ա(Clerk)����������(Customer)�ӵ�Ա��ȡ
 �߲�Ʒ����Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ(����:20���������������ͼ��������Ĳ�Ʒ��
 ��Ա���������ͣһ�£���������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û��
 ��Ʒ�ˣ���Ա����������ߵ�һ�£���������в�Ʒ����֪ͨ��������ȡ�߲�Ʒ��
 1.�Ƿ���ڶ��̣߳��ǣ�
 2.����̷ֱ߳���ʲô�أ�������  ������
 3.�Ƿ���ڹ������ݣ���
 4.���������ǣ���Ʒ����Ҫ�����̵߳�ͬ������������̵߳İ�ȫ����
 5.�Ƿ�����̵߳�ͨ�ţ���
 */

class Clerk{//��Ա
	int product;
	
	public synchronized void consumeProduct(){//���Ѳ�Ʒ
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			product--;
			notifyAll();
		}
	}
	
	public synchronized void addProduct(){//������Ʒ
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			notifyAll();
		}
	}
}

class Comsumer implements Runnable{//������
	Clerk clerk;
	public Comsumer(Clerk clerk){
		this.clerk = clerk;
	}
	@Override
	public void run() {
		System.out.println("�����߿�ʼ���Ѳ�Ʒ");
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

class Productor implements Runnable{//������
	Clerk clerk;
	
	public Productor(Clerk clerk){
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("�����߿�ʼ������Ʒ");
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
		Thread t1 = new Thread(p1);//������һ��������
		Thread t2 = new Thread(p1);
		
		Comsumer c1 = new Comsumer(clerk);
		Thread tt1 = new Thread(c1);//������һ��������
		
		t1.start();
		t2.start();
		tt1.start();
		
	}
}
