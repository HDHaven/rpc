package com.haven.tools.rpc.tcp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>�����ڷ��񷽿��Ƶ��ù��̣�������������̳߳ء���ʱʱ��, ע������
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Processor {

	/**
	 * �����ע�����ļ���
	 */
	private static Map<String, Class<?>> serviceCollection = new HashMap<String, Class<?>>();
	
	static {
		serviceCollection.put("RemoteAPI", RemoteAPI.class);
	}
	
	private static Processor instance = new Processor();
	private static Processor getInstance() {
		// ����ģʽ����һ��ʵ�����ڲ�����
		return instance;
	}
	private Processor() {}
	
	// ע��һ������
	public static boolean registry(String serviceName, Class<?> clazz) {
		if(!isExisted(serviceName)) {
			serviceCollection.put(serviceName, clazz);
			System.out.println("registry service ["+ serviceName +"] successfully");
			return true;
		} else {
			System.out.println("The service [ "+ serviceName +" ] has been existed! ");
			return false;
		}
	}
	
	// �Ƴ�һ������
	public static boolean unRegistry(String serviceName) {
		if(isExisted(serviceName)) {
			/*Class<?> clazz =*/ serviceCollection.remove(serviceName);
			System.out.println("unregistry service [ "+ serviceName +" ] successfully...");
			return true;
		} else {
			System.out.println("The service [ "+ serviceName +" ] is not existed!");
			return false;
		}
	}
	
	// ��ȡһ������
	private static Class<?> getService(String serviceName) {
		if(!isExisted(serviceName)) {
			System.out.println("The service [ "+ serviceName +" ] is not existed!");
			return null;
		}
		return serviceCollection.get(serviceName);
	}
	
	// �ж�һ�������Ƿ����
	public static boolean isExisted(String serviceName) {
		return serviceCollection.containsKey(serviceName) ? true : false;
	}
	
	// ����һ���̴߳���ҵ��
	public static void dealService(Socket socket) {
		Processor.getInstance().new ServiceThread(socket).start();
	}
	
	// ����ҵ����߳���
	private class ServiceThread extends Thread {

		private Socket socket;
		
		private ServiceThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			System.out.println("��ʼ����ҵ��...");
			try {
				// ��ȡ�ͻ��˴���������Ϣ
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String jsonStr = in.readLine();
				// ����
				Request request = Protocol.decode(jsonStr);
				// ���ݷ�������ȡ����ҵ��������
				String serviceName = request.getClassName();
				Class<?> clazz = Processor.getService(serviceName);
				request.setClassName(clazz.getName());
				// ���÷����ȡ���ý��
				Invoker invoker = new Invoker();
				Response response = invoker.invoke(request);
				// �����ý�����뷵�ظ��ͻ���
				String result = Protocol.encode(response);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println(result);
				out.flush();
				out.close();
				in.close();
			} catch(Exception e) {
				System.out.println("ҵ����ʧ��: "+ e.getMessage());
				e.printStackTrace();
			}
			System.out.println("ҵ�������...");
		}
		
	}
	
}
