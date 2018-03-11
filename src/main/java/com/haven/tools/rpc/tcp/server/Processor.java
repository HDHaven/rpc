package com.haven.tools.rpc.tcp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>负责在服务方控制调用过程，包括管理调用线程池、超时时间, 注册服务等
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Processor {

	/**
	 * 服务端注册服务的集合
	 */
	private static Map<String, Class<?>> serviceCollection = new HashMap<String, Class<?>>();
	
	static {
		serviceCollection.put("RemoteAPI", RemoteAPI.class);
	}
	
	private static Processor instance = new Processor();
	private static Processor getInstance() {
		// 单例模式创建一个实例供内部调用
		return instance;
	}
	private Processor() {}
	
	// 注册一个服务
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
	
	// 移除一个服务
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
	
	// 获取一个服务
	private static Class<?> getService(String serviceName) {
		if(!isExisted(serviceName)) {
			System.out.println("The service [ "+ serviceName +" ] is not existed!");
			return null;
		}
		return serviceCollection.get(serviceName);
	}
	
	// 判断一个服务是否存在
	public static boolean isExisted(String serviceName) {
		return serviceCollection.containsKey(serviceName) ? true : false;
	}
	
	// 开启一个线程处理业务
	public static void dealService(Socket socket) {
		Processor.getInstance().new ServiceThread(socket).start();
	}
	
	// 处理业务的线程类
	private class ServiceThread extends Thread {

		private Socket socket;
		
		private ServiceThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			System.out.println("开始处理业务...");
			try {
				// 获取客户端传过来的信息
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String jsonStr = in.readLine();
				// 解码
				Request request = Protocol.decode(jsonStr);
				// 根据服务名获取处理业务的类对象
				String serviceName = request.getClassName();
				Class<?> clazz = Processor.getService(serviceName);
				request.setClassName(clazz.getName());
				// 调用服务获取调用结果
				Invoker invoker = new Invoker();
				Response response = invoker.invoke(request);
				// 将调用结果编码返回给客户端
				String result = Protocol.encode(response);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println(result);
				out.flush();
				out.close();
				in.close();
			} catch(Exception e) {
				System.out.println("业务处理失败: "+ e.getMessage());
				e.printStackTrace();
			}
			System.out.println("业务处理完毕...");
		}
		
	}
	
}
