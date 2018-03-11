package com.haven.tools.rpc.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <p>负责维持客户方和服务方的连接通道和发送数据到服务方  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Connector {

	/**
	 * <p>维持客户方和服务方的连接通道和发送数据到服务方
	 * 
	 * @param jsonStr
	 * @return 返回请求服务结果
	 */
	public String connect(String jsonStr) {
		Socket socket = null;
		String result = null;
		try {
			System.out.println("准备连接服务器...");
			// 连接服务器
			socket = new Socket("localhost", 8888);// TODO
			// 获取输出流, 调用远程服务
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(jsonStr);
			out.flush();
			// 获取输入流, 等待服务器返回结果
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			result = in.readLine();
			in.close();
			out.close();
			System.out.println("访问服务器成功...");
		} catch (IOException e) {
			System.out.println("连接服务器失败: "+ e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(socket != null)
					socket.close();
			} catch (IOException e) {
			}
		}
		
		return result;
	}
	
}
