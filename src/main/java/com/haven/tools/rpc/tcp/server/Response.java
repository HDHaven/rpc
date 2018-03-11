package com.haven.tools.rpc.tcp.server;

import java.io.Serializable;

/**
 * <p>��Ӧʵ��
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;// ��ӦΨһ��ʶ, �������ʶ��Ӧ
	private Integer statusCode;// ���ص�״̬��, 200��������ɹ�, 404����������Դ������, etc
	private Object result;// ��Ӧ���
	
	public Response() {}

	public Response(Long id, Integer statusCode, Object result) {
//		super();
		this.id = id;
		this.statusCode = statusCode;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", statusCode=" + statusCode + ", result=" + result + "]";
	}

}
