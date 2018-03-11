package com.haven.tools.rpc.tcp.client;

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
	 * <p>将请求对象封装成json格式字符串
	 * 
	 * @param request
	 * @return 成功返回{@link Request }对象的json格式字符串, 否则返回null
	 * @see Request
	 */
	public static String encode(Request request) {
		String jsonStr = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonStr = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			System.out.println("Object to Json error: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
		return jsonStr;
	}
	
	/**
	 * <p>将json格式字符串转换成响应对象
	 * 
	 * @param jsonStr
	 * @return 成功返回{@link Response }对象, 否则返回null
	 * @see Response
	 */
	public static Response decode(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		Response response = null;
		try {
			response = mapper.readValue(jsonStr, Response.class);
		} catch (IOException e) {
			System.out.println("JSON to Object error: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
		return response;
	}
	
}
