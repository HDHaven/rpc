package com.haven.tools.rpc.tcp.client;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>负责编码调用信息和发送调用请求到服务方并等待调用结果返回
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Invoker {

	private final AtomicLong counter = new AtomicLong();
//	private static Map<Long, Response> resultMap = new ConcurrentHashMap<Long, Response>();
	
	public Object invoke(String className, String methodName, Object[] args) {
		// 1.编码
		Request request = new Request();
		request.setId(counter.incrementAndGet());
		request.setClassName(className);
		request.setMethodName(methodName);
		request.setTimeout(30000L);// 30秒超时
		request.setArgs(args);
		String jsonStr = Protocol.encode(request);
		
		// 2.发送调用请求, 等待返回结果
		String result = new Connector().connect(jsonStr);
		
		// 3.解码, 将结果返回调用客户端
		Response response = Protocol.decode(result);
//		resultMap.put(response.getId(), response);
		if(response != null && response.getId() == request.getId()
				&& 200 == response.getStatusCode()) {
			// 请求成功
			Object obj = response.getResult();
			return obj;
		} else {
			// TODO 请求失败, 抛出异常
			return null;
		}
	}
	
}
