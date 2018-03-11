package com.haven.tools.rpc.tcp.server;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>负责协议编/解码  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Protocol {

	/**
	 * <p>将客户端传过来的json格式字符串转换成{@link Request }对象
	 * 
	 * @param jsonStr
	 * @return 成功返回{@link Request }对象, 否则返回null
	 * @see Request
	 */
	public static Request decode(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		Request request = null;
		try {
			request = mapper.readValue(jsonStr, Request.class);
		} catch (IOException e) {
			System.out.println("Json to Object error: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
		return request;
	}
	
	/**
	 * <p>将服务产生的结果转换成json返回给客户端
	 * 
	 * @param response
	 * @return 成功返回{link Response }对象对应的JSON格式字符串, 否则返回null
	 * @see Response
	 */
	public static String encode(Response response) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			System.out.println("Object to Json error: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
		return jsonStr;
	}
	
}
