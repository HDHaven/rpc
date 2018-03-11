package com.haven.tools.rpc.tcp.client;

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
	 * <p>����������װ��json��ʽ�ַ���
	 * 
	 * @param request
	 * @return �ɹ�����{@link Request }�����json��ʽ�ַ���, ���򷵻�null
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
	 * <p>��json��ʽ�ַ���ת������Ӧ����
	 * 
	 * @param jsonStr
	 * @return �ɹ�����{@link Response }����, ���򷵻�null
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
