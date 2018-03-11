package com.haven.tools.rpc.tcp.client;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>������������Ϣ�ͷ��͵������󵽷��񷽲��ȴ����ý������
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Invoker {

	private final AtomicLong counter = new AtomicLong();
//	private static Map<Long, Response> resultMap = new ConcurrentHashMap<Long, Response>();
	
	public Object invoke(String className, String methodName, Object[] args) {
		// 1.����
		Request request = new Request();
		request.setId(counter.incrementAndGet());
		request.setClassName(className);
		request.setMethodName(methodName);
		request.setTimeout(30000L);// 30�볬ʱ
		request.setArgs(args);
		String jsonStr = Protocol.encode(request);
		
		// 2.���͵�������, �ȴ����ؽ��
		String result = new Connector().connect(jsonStr);
		
		// 3.����, ��������ص��ÿͻ���
		Response response = Protocol.decode(result);
//		resultMap.put(response.getId(), response);
		if(response != null && response.getId() == request.getId()
				&& 200 == response.getStatusCode()) {
			// ����ɹ�
			Object obj = response.getResult();
			return obj;
		} else {
			// TODO ����ʧ��, �׳��쳣
			return null;
		}
	}
	
}
