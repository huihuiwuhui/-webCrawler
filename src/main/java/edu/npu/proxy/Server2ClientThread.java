package edu.npu.proxy;

import java.io.InputStream;
import java.io.OutputStream;

import edu.npu.utils.HexUtil;

public class Server2ClientThread extends Thread{
	private InputStream sis;
    private OutputStream cos;

    public Server2ClientThread(InputStream sis, OutputStream cos) {
        this.sis = sis;
        this.cos = cos;
    }

    public void run() {
    	int length;
    	byte bytes[] = new byte[1024];
		while(true){
			try {
				if ((length = sis.read(bytes)) > 0) {
					cos.write(bytes, 0, length);//将http请求头写到目标主机
					//System.out.println("接收到的数据"+HexUtil.bytesToHexString(bytes, 0, length));
					cos.flush();
				} else if (length < 0)
					break;
			} catch (Exception e) {
				//System.out.println("\nRequest Exception:");
			}
		}
    }
}
