package com.itcv.main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
     public static void main(String[] args) {
		URLConnection urlconn = null;
	        BufferedReader br = null;
	        PrintWriter pw = null;
//	         
	       // String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//urlƥ�����
	      //  Pattern p = Pattern.compile(regex);
	        try {
	        //	System.setProperty("http.proxyHost", "127.0.0.1");  
	        //	System.setProperty("http.proxyPort", "8888"); 
	        	//URL url = new URL("http://www.qingdouxs.org/read/3897/843345.html");//��ȡ����ַ��������ȡ����һ��������վ"";
	        	URL url = new URL("104.31.13.156:80/month/2018-01/");
	           // url = new URL("https://www.rndsystems.com/cn");//��ȡ����ַ��������ȡ����һ��������վ
	            urlconn = url.openConnection();
	            urlconn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
	            pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true);//����ȡ�������ӷŵ�D�̵�SiteURL�ļ���
	            br = new BufferedReader(new InputStreamReader(
	                    urlconn.getInputStream()));
	            String buf = null;
	            while ((buf = br.readLine()) != null) {
	              //  Matcher buf_m = p.matcher(buf);
	                 System.out.println(buf);
	            }
	            System.out.println("��ȡ�ɹ�^_^");
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            pw.close();
	        }
	    }
}
