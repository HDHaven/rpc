package com.haven.tools.rpc.tcp.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>远程接口的代理实现
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
		// 获取远程调用的方法名
		String methodName = method.getName();
		// 获取远程调用的类名
		String className = method.getDeclaringClass().getName();
		className = className.substring(className.lastIndexOf('.')+1);
		Invoker invoker = new Invoker();
		Object obj = invoker.invoke(className, methodName, args);
		return obj;
	}
	
	/**
	 * <p>获取代理对象
	 * 
	 * @param clazz 被代理对象, 通常是一个接口
	 * @return 返回代理对象实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{ clazz }, new ProxyClient());
	}
	
}
