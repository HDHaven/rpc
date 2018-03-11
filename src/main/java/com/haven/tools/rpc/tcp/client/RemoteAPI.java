package com.haven.tools.rpc.tcp.client;

/**
 * <p>负责导入远程接口的代理实现
 * <p>远程API的接口
 * 
 * @author Haven
 * @date 2018/01/12
 */
public interface RemoteAPI {

	/**
	 * <p>客户端接口, 根据用户名获取用户地址信息列表
	 * 
	 * @param username
	 * @return 返回地址地址信息列表
	 */
	public Address[] getAddrList(String username);
	
	public String sayHello(String username);
	
}
