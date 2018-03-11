package com.haven.tools.rpc.tcp.server;

import java.io.Serializable;

/**
 * <p>响应实例
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;// 响应唯一标识, 与请求标识对应
	private Integer statusCode;// 返回的状态码, 200代表请求成功, 404代表请求资源不存在, etc
	private Object result;// 响应结果
	
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
