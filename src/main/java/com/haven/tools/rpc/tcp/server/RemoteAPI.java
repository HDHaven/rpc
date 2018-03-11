package com.haven.tools.rpc.tcp.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>���𵼳�Զ�̽ӿ�
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class RemoteAPI {
	
	// ģ�����ݿ�洢����
	private static Map<String, List<Address>> repository = new HashMap<String, List<Address>>();
	
	// ��ʼ������
	public RemoteAPI() {
		List<Address> list1 = new ArrayList<Address>();
		Address addr1 = new Address(10000L, 10000L, "xxʡ", "xx��", "xx��xx·", "xxx��", "xxx", "18800001111");
		Address addr2 = new Address(10001L, 10000L, "xxʡ", "xx��", "xx��xx·", "xxx��", "xxx", "18800001111");
		list1.add(addr1);
		list1.add(addr2);
		// �û���Ϊkey, ��ַ�б�Ϊvalue
		repository.put("Haven", list1);
		
		List<Address> list2 = new ArrayList<Address>();
		Address addr3 = new Address(10002L, 10002L, "xxʡ", "xx��", "xx��xx·", "xxx��", "xxx", "18800001111");
		Address addr4 = new Address(10003L, 10002L, "xxʡ", "xx��", "xx��xx·", "xxx��", "xxx", "18800001111");
		Address addr5 = new Address(10005L, 10002L, "xxʡ", "xx��", "xx��xx·", "xxx��", "xxx", "18800001111");
		list2.add(addr3);
		list2.add(addr4);
		list2.add(addr5);
		// �û���Ϊkey, ��ַ�б�Ϊvalue
		repository.put("Jayin", list2);
	}
	
	/**
	 * <p>�����û�����ȡ��ַ��Ϣ�б�
	 * 
	 * @param username �û���
	 * @return �ɹ����ص�ַ��Ϣ�б�, ���򷵻�null.
	 */
	public List<Address> getAddrList(String username) {
		if(!repository.containsKey(username)) return null;
		List<Address> list = repository.get(username);
		return list; 
	}
	
//	private Address[] toArray(List<Address> list) {
//		if(list == null || list.size() < 1) return null;
//		Address[] array = new Address[list.size()];
//		for(int i = 0; i < list.size(); i++) {
//			array[i] = list.get(i);
//		}
//		return array;
//	}
	
	public String sayHello(String username) {
		return "Hello "+ username;
	}
	
}
