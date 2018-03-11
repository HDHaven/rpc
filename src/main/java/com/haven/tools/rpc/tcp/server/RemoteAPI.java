package com.haven.tools.rpc.tcp.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>负责导出远程接口
 * 
 * @author Haven
 * @date 2018/01/12
 */
public class RemoteAPI {
	
	// 模拟数据库存储数据
	private static Map<String, List<Address>> repository = new HashMap<String, List<Address>>();
	
	// 初始化数据
	public RemoteAPI() {
		List<Address> list1 = new ArrayList<Address>();
		Address addr1 = new Address(10000L, 10000L, "xx省", "xx市", "xx区xx路", "xxx号", "xxx", "18800001111");
		Address addr2 = new Address(10001L, 10000L, "xx省", "xx市", "xx区xx路", "xxx号", "xxx", "18800001111");
		list1.add(addr1);
		list1.add(addr2);
		// 用户名为key, 地址列表为value
		repository.put("Haven", list1);
		
		List<Address> list2 = new ArrayList<Address>();
		Address addr3 = new Address(10002L, 10002L, "xx省", "xx市", "xx区xx路", "xxx号", "xxx", "18800001111");
		Address addr4 = new Address(10003L, 10002L, "xx省", "xx市", "xx区xx路", "xxx号", "xxx", "18800001111");
		Address addr5 = new Address(10005L, 10002L, "xx省", "xx市", "xx区xx路", "xxx号", "xxx", "18800001111");
		list2.add(addr3);
		list2.add(addr4);
		list2.add(addr5);
		// 用户名为key, 地址列表为value
		repository.put("Jayin", list2);
	}
	
	/**
	 * <p>根据用户名获取地址信息列表
	 * 
	 * @param username 用户名
	 * @return 成功返回地址信息列表, 否则返回null.
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
