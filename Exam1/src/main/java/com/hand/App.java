package com.hand;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class App {
    public static void main (String args[])
    {
    	Get.getFile();
    }
}

class Get
{
	public static void getFile(){
		try {
			URL url=new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection connection=url.openConnection();
			File file=new File("exam.pdf");

			FileOutputStream os=new FileOutputStream(file);
			BufferedOutputStream bos=new BufferedOutputStream(os);

			
			InputStream is=connection.getInputStream();
			BufferedInputStream isr=new BufferedInputStream(is);

 
			 int len = 0;
			 byte b[]=new byte[100];
			 while((len=isr.read(b) ) !=-1)
			 {
				 bos.write(b,0,len);
			 }
			 bos.flush();
			os.close();
			bos.close();
			is.close();
			isr.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}