package com.haven.tools.rpc.tcp.client;

/**
 * <p>������Զ�̽ӿڵĴ���ʵ��
 * <p>Զ��API�Ľӿ�
 * 
 * @author Haven
 * @date 2018/01/12
 */
public interface RemoteAPI {

	/**
	 * <p>�ͻ��˽ӿ�, �����û�����ȡ�û���ַ��Ϣ�б�
	 * 
	 * @param username
	 * @return ���ص�ַ��ַ��Ϣ�б�
	 */
	public Address[] getAddrList(String username);
	
	public String sayHello(String username);
	
}
