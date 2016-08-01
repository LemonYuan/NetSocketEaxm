package com.hand;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonObject;

public class App {
	
          public static void main(String args[])
          {
        	 
             String result[]=Parse.split(GetS.getFile());
             for (int i = 0; i < result.length; i++) {
            	 System.out.println(result[i]);
			}
             createXML.create(result);
             createJson.create(result);
          }
}

class createJson{

	public static void create(String s[]){
		 JsonObject js=new JsonObject();
		  js.addProperty("name", s[0]);
		  js.addProperty("open", s[1]);
		  js.addProperty("close", s[2]);
		  js.addProperty("current", s[3]);
		  js.addProperty("higt", s[4]);
		  js.addProperty("low", s[5]);		
	        System.out.println(js.toString());
	        
	        try {
				FileWriter fw=new FileWriter("stock.json");
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(js.toString());
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	 
}

class createXML{
	   public static void create(String s[]){
		   try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			   DocumentBuilder builder=factory.newDocumentBuilder();
			   Document document=builder.newDocument();
			   
			   
			   Element root = document.createElement("stock");

			   Element name = document.createElement("name");
			   name.setTextContent(s[0]);
			   Element open = document.createElement("open");
			   open.setTextContent(s[1]);
			   Element close = document.createElement("close");
			   close.setTextContent(s[2]);
			   Element current = document.createElement("current");
			   current.setTextContent(s[3]);
			   Element high = document.createElement("high");
			   high.setTextContent(s[4]);
			   Element low = document.createElement("low");
			   low.setTextContent(s[5]);

			   root.appendChild(name);
			   root.appendChild(open);
			   root.appendChild(close);
			   root.appendChild(current);
			   root.appendChild(low);
			   root.appendChild(high);

			   document.appendChild(root);
			   
			   
			     TransformerFactory tf=TransformerFactory.newInstance();

					Transformer ts=tf.newTransformer();
					StringWriter writer=new StringWriter();
					ts.transform(new DOMSource(document), new StreamResult(new File("stock.xml")));
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
				
				
				
				

		     
	   }
}


class Parse{
	public static String[] split(String s){
		String sub=s.substring(21);
        String sub1[]=sub.split(",");
        String result[]=new String[6];
        for(int i=0;i<6;i++)
        {
        	result[i]=sub1[i];
        }
        return result;
	}
}

class GetS
{
	public static String  getFile(){
		 StringBuilder sb=new StringBuilder();
		try {
			URL url=new URL("http://hq.sinajs.cn/list=sh601006");
			URLConnection connection=url.openConnection();
			File file=new File("stock.xml");
			
			InputStream is=connection.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"GBK");
			BufferedReader bsr=new BufferedReader(isr);

                
               String line;
			 while((line=bsr.readLine())!=null)
			 {
				 sb.append(line);
			 }
			bsr.close();
			isr.close();
			is.close();

			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}