package com.haven.tools.rpc.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <p>����ά�ֿͻ����ͷ��񷽵�����ͨ���ͷ������ݵ�����  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Connector {

	/**
	 * <p>ά�ֿͻ����ͷ��񷽵�����ͨ���ͷ������ݵ�����
	 * 
	 * @param jsonStr
	 * @return �������������
	 */
	public String connect(String jsonStr) {
		Socket socket = null;
		String result = null;
		try {
			System.out.println("׼�����ӷ�����...");
			// ���ӷ�����
			socket = new Socket("localhost", 8888);// TODO
			// ��ȡ�����, ����Զ�̷���
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(jsonStr);
			out.flush();
			// ��ȡ������, �ȴ����������ؽ��
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			result = in.readLine();
			in.close();
			out.close();
			System.out.println("���ʷ������ɹ�...");
		} catch (IOException e) {
			System.out.println("���ӷ�����ʧ��: "+ e.getMessage());
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
