package com.haven.tools.rpc.tcp.server;

import java.lang.reflect.Method;

/**
 * <p>������÷���˽ӿڵľ���ʵ�ֲ����ص��ý�� 
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Invoker {

	/**
	 * <p>ͨ���������{@link RemoteAPI#getAddrList(String) }���� TODO
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
					// ���������
					System.out.println("׼�����÷���: "+ method.getName());
					if(args == null || args.length < 1) {
						// ���õ����޲η���
						Object result = method.invoke(clazz.newInstance());
						response.setResult(result);
						response.setStatusCode(200);
						break;
					} else if(args.length == method.getParameterCount()) {
						// �����������
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
			System.out.println("������÷���ʧ��: "+ e.getMessage());
			response.setStatusCode(404);
			e.printStackTrace();
		}
		
		return response;
	}
	
}
