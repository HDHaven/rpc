package com.haven.tools.rpc.tcp.server;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>����ʵ��
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;// ����Ψһ��ʶ
	private String className;// ��Ҫ����Ľӿ�����
	private String methodName;// ���øýӿڷ����ķ�����
	private Long timeout;// ����ʱʱ��
	private Object[] args;// ���ýӿ���Ҫ�Ĳ���, keyΪ������, valueΪ����ֵ
	
	public Request() {}

	public Request(Long id, String className, String methodName, Long timeout, Object[] args) {
//		super();
		this.id = id;
		this.className = className;
		this.methodName = methodName;
		this.timeout = timeout;
		this.args = args;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", className=" + className + ", methodName=" + methodName + ", timeout=" + timeout
				+ ", args=" + Arrays.toString(args) + "]";
	}

}
