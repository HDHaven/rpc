package com.haven.tools.rpc.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p> ������տͻ������󲢷���������  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Acceptor {

	public static void main(String[] args) {
		// 1.��������, �ȴ��ͻ��˵�����
		int port = 8888;
		int count = 0;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("�����������ɹ�, �ȴ��ͻ�������...");
			while(true) {
				Socket socket = serverSocket.accept();// ����״̬, �ȴ��ͻ��˵�����
				System.out.println("��"+ (++count) +"���ͻ������ӳɹ�...");
				// 2.����ҵ�����߳�
				Processor.dealService(socket);
			}
		} catch (IOException e) {
			System.out.println("����������ʧ��: "+ e.getMessage());
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