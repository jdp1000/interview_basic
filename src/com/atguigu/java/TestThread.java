package com.atguigu.java;
//���������̣߳��ֱ��ӡ100���ڵ�ż��������
//�ж϶���߳��Ƿ�����̵߳İ�ȫ���⣺�Ƿ���ڹ�������
public class TestThread {
	public static void main(String[] args) {
		//�����˼̳�Thread������������������
		new Thread("�߳�1"){
			public void run(){
				for(int i = 1;i <= 100;i++){
					if(i % 2 == 0){
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
		
		new Thread("�߳�2"){
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
