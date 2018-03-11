package com.haven.tools.rpc.tcp.client;

public class MainClient {

	public static void main(String[] args) {
		
		RemoteAPI client = ProxyClient.getProxy(RemoteAPI.class);
		String msg = client.sayHello("Haven");
		System.out.println("服务器返回结果: "+ msg);
		
//		Address[] array = client.getAddrList("Haven");
//		for(int i = 0; i < 100; i++) {
//			new MyThread(client, "Thread#"+ i).start();
//		}
	}
	
}

class MyThread extends Thread {
	
	private RemoteAPI client;
	private String msg;
	
	public MyThread(RemoteAPI client, String msg) {
		this.client = client;
		this.msg = msg;
	}
	
	public void run() {
		String result = client.sayHello(msg);
		System.out.println("I say "+ msg +", result is "+ result);
	}
	
}
