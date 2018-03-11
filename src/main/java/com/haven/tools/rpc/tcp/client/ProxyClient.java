package com.haven.tools.rpc.tcp.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>Զ�̽ӿڵĴ���ʵ��
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class ProxyClient implements InvocationHandler {

	/**
	 * (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ��ȡԶ�̵��õķ�����
		String methodName = method.getName();
		// ��ȡԶ�̵��õ�����
		String className = method.getDeclaringClass().getName();
		className = className.substring(className.lastIndexOf('.')+1);
		Invoker invoker = new Invoker();
		Object obj = invoker.invoke(className, methodName, args);
		return obj;
	}
	
	/**
	 * <p>��ȡ�������
	 * 
	 * @param clazz ���������, ͨ����һ���ӿ�
	 * @return ���ش������ʵ��
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{ clazz }, new ProxyClient());
	}
	
}
