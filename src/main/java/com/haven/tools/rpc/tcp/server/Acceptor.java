package com.haven.tools.rpc.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p> 负责接收客户方请求并返回请求结果  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Acceptor {

	public static void main(String[] args) {
		// 1.启动服务, 等待客户端的请求
		int port = 8888;
		int count = 0;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("服务器启动成功, 等待客户端连接...");
			while(true) {
				Socket socket = serverSocket.accept();// 阻塞状态, 等待客户端的连接
				System.out.println("第"+ (++count) +"个客户端连接成功...");
				// 2.启动业务处理线程
				Processor.dealService(socket);
			}
		} catch (IOException e) {
			System.out.println("启动服务器失败: "+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null)
					serverSocket.close();	
			} catch (IOException e) {
			}
		}
	}
	
}