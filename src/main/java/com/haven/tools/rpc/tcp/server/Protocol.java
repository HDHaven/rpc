package com.haven.tools.rpc.tcp.server;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>����Э���/����  
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Protocol {

	/**
	 * <p>���ͻ��˴�������json��ʽ�ַ���ת����{@link Request }����
	 * 
	 * @param jsonStr
	 * @return �ɹ�����{@link Request }����, ���򷵻�null
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
	 * <p>����������Ľ��ת����json���ظ��ͻ���
	 * 
	 * @param response
	 * @return �ɹ�����{link Response }�����Ӧ��JSON��ʽ�ַ���, ���򷵻�null
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
