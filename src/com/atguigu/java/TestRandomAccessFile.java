package com.atguigu.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {
	@Test
	public void test1() throws Exception {
		RandomAccessFile raf = new RandomAccessFile(new File("hello.txt"), "rw");
	
//		raf.seek(7);
//		raf.write("xyz".getBytes());
//		
//		raf.close();
		//1.
		raf.seek(7);
		StringBuffer sb = new StringBuffer();
		byte[] b = new byte[20];
		int len;
		while((len = raf.read(b)) != -1){
			String str = new String(b,0,len);
			sb.append(str);
		}
		//2.
		raf.seek(7);
		raf.write("ÄãºÃ".getBytes());
		raf.write(sb.toString().getBytes());
		
		raf.close();
	}
}
