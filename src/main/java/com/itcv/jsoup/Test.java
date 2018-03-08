package com.itcv.jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {
   public static void main(String[] args) {
	   List<String> urlList = new ArrayList<String>();
	   Document doc = null;
	   PrintWriter pw = null;
	    try {
	          doc = Jsoup.connect("http://www.qingdouxs.org/modules/article/download.php?id=3897").userAgent("Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like               Gecko").timeout(30000).get();
	          
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
	    for(Iterator<Element> ir = doc.select("#kui-book-show a").iterator();ir.hasNext();){
	    	//System.out.println(ir.next().toString());
	    	Element element = ir.next();
	    	String href = element.attr("href");
	    	urlList.add("http://www.qingdouxs.org"+href);
	 }
	 try { 
		 pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true); 
	  for (int i = 0; i <urlList.size(); i++) {
	          doc = Jsoup.connect(urlList.get(i)).userAgent("Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like               Gecko").timeout(30000).get();
	          System.out.println("=============="+urlList.get(i)+"================");
	    for(Iterator<Element> ir = doc.select("#kui-page-read-txt").iterator();ir.hasNext();){
	    	//System.out.println(ir.next().toString());
	    	Element element = ir.next();
	    	String str = element.html();
	    	str = str.replaceAll("&nbsp;","");
	   	    str = str.replaceAll("<br>", "");
	    	pw.print(str);
	    	//String href = element.attr("href");
	    	//urlList.add("http://www.qingdouxs.org"+href);
	 } 
	}
	    } catch (IOException e) {
	         e.printStackTrace();
	    }  
	   
}
}
