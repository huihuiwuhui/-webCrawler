package edu.npu.proxy;

import java.io.InputStream;
import java.io.OutputStream;

import edu.npu.utils.HexUtil;

public class Client2ServerThread extends Thread{
	private InputStream cis;
    private OutputStream sos;

    public Client2ServerThread(InputStream cis, OutputStream sos) {
        this.cis = cis;
        this.sos = sos;
    }

    public void run() {
    	int length;
    	byte bytes[] = new byte[1024];
    	StringBuffer sb = new StringBuffer("\n");  
        //http协议中请求行  
        //sb.append("GET "+url+" HTTP/1.1\r\n");  
        //http协议中请求头  
        sb.append("Host: www.141jav.com\r\n");  
        sb.append("Proxy-Connection: Keep-Alive\r\n");  
        sb.append("User-Agent: Apache-HttpClient/4.5.5 (Java/1.8.0_144)\r\n");  
        //注，这是关键的关键，忘了这里让我搞了半个小时。这里一定要一个回车换行，表示消息头完，不然服务器会等待  
        sb.append("\r\n");
		while(true){
			try {
				if ((length = cis.read(bytes)) > 0) {
					//
					System.out.println("请求的数据"+HexUtil.bytesToHexString(sb.toString().getBytes(), 0, sb.toString().getBytes().length));
					System.out.println("原始请求的数据"+HexUtil.bytesToHexString(bytes, 0, length));
					sos.write(sb.toString().getBytes());
					//sos.write(bytes, 0, length);//将http请求头写到目标主机
					sos.flush();
				} else if (length < 0)
					break;
			} catch (Exception e) {
				//System.out.println("\nRequest Exception:");
				//e.printStackTrace();
			}
		}
    }
}
