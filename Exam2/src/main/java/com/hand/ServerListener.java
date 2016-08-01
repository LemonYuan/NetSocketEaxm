package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{

public void run() {
	try {
		ServerSocket s=new ServerSocket(23333);
		File file=new File("../Exam1/exam.pdf");
		FileInputStream fis=new FileInputStream(file);
		BufferedInputStream bis=new BufferedInputStream(fis);
		Socket socket=s.accept();
		
		FileOutputStream fos=new FileOutputStream(new File("exam2.pdf"));
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		byte b[]=new byte[100];
		while(bis.read(b)!=-1)
		{				
				bos.write(b);
		}
	    bos.flush();
		fis.close();
		bis.close();
		fos.close();
		bos.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	while(true)
	{
		
	}
}
}