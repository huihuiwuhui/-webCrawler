import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.npu.proxy.HttpProxyMainThread;

public class proxyd {

	public static void main(String[] args) {
		
			int port = 8888;
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("The proxy have start on port:" + port + "\n");
				while (true) {
					Socket socket = null;
					try {
						socket = serverSocket.accept();
						new HttpProxyMainThread(socket).start();//鏈変竴涓姹傚氨鍚姩涓�涓嚎绋�
					} catch (Exception e) {
						System.out.println("Thread start fail");
					}
				}
			} catch (IOException e1) {
				System.out.println("proxyd start fail\n");
			}finally{
				try {
					serverSocket.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		 
	}
	
}
