package com.itcv.jsoup;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.ProxyClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class IPv6Connection {
	public static void main(String args[]) {
		URI ui = null;
		try {
			//ui = new URI("http://www.141jav.com/");
			//ui = new URI("http://www.google.hk/");
			//ui = new URI("http://www.baidu.com/");
			ui = new URI("http://www.141jav.com/month/2018-02/");
			System.out.println(ui.getHost());
			System.out.println(ui.isAbsolute());

			HttpClient hc = null;
			hc = new DefaultHttpClient();
			HttpHost proxy = new HttpHost("127.0.0.1", 8888);
			hc.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

			HttpGet hg = new HttpGet(ui);

			HttpResponse hr = null;
			hr = hc.execute(hg);
			System.out.println(hr.getStatusLine());
			HttpEntity en = hr.getEntity();
			InputStream in = en.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			String temp = null;
			PrintWriter pw = new PrintWriter(new FileWriter("D:/text123.txt"), true);
			StringBuffer str =new StringBuffer();
			while ((temp = br.readLine()) != null) {
				str.append(temp);
				System.out.println(temp);
			}
			br.close();
			Document doc = Jsoup.parse(str.toString());
            pw.write(str.toString());
            pw.flush();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}