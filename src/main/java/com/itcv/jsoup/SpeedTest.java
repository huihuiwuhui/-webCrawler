package com.itcv.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SpeedTest {

	public static void main(String[] args) {
		 Document doc = null;
		 try {
			doc = Jsoup.connect("http://www.141jav.com/").userAgent("Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like               Gecko").timeout(30000).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
