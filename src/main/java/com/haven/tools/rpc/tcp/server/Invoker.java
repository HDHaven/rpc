package com.haven.tools.rpc.tcp.server;

import java.lang.reflect.Method;

/**
 * <p>负责调用服务端接口的具体实现并返回调用结果 
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Invoker {

	/**
	 * <p>通过反射调用{@link RemoteAPI#getAddrList(String) }方法 TODO
	 * 
	 * @param request
	 * @return 
	 * @throws Exception 
	 */
	public Response invoke(Request request) {
		Response response = new Response();
		response.setId(request.getId());
		try {
			String className = request.getClassName();
			Class<?> clazz = Class.forName(className);
			String methodName = request.getMethodName();
			Object[] args = request.getArgs();
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method method : methods) {
				if(method.getName().equals(methodName)) {
					// 方法名相等
					System.out.println("准备调用方法: "+ method.getName());
					if(args == null || args.length < 1) {
						// 调用的是无参方法
						Object result = method.invoke(clazz.newInstance());
						response.setResult(result);
						response.setStatusCode(200);
						break;
					} else if(args.length == method.getParameterCount()) {
						// 参数个数相等
						Object result = method.invoke(clazz.newInstance(), args);
						response.setResult(result);
						response.setStatusCode(200);
						break;
					}
				} 
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			response.setStatusCode(404);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("反射调用方法失败: "+ e.getMessage());
			response.setStatusCode(404);
			e.printStackTrace();
		}
		
		return response;
	}
	
}
