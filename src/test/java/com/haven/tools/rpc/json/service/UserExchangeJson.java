package com.haven.tools.rpc.json.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haven.tools.rpc.json.domain.Address;
import com.haven.tools.rpc.json.domain.User;

public class UserExchangeJson {

	@Test
	public void testDomainToJson() throws ParseException, IOException {
		User user = new User(10000L, "Haven", "haven1221@163.com", null);
		user.setParams(new Object[]{"11", new Address(10000L, "µÿ÷∑√Ë ˆ")});
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(sdf.parse("1994-12-21"));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(user);
		System.out.println(jsonStr);
		
		User u = mapper.readValue(jsonStr, User.class);
		System.out.println(u);
	}
	
	@Test
	public void testJsonToDomain() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "{\"id\":10000,\"username\":\"Haven\",\"email\":\"haven1221@163.com\",\"birthday\":787939200000}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		User user = mapper.readValue(jsonStr, User.class);
		System.out.println(user);
		
	}
	
	@Test
	public void testList() throws IOException {
		User u1 = new User(11L, "asdf", "asdf", new Date());
		User u2 = new User(11L, "asdf", "asdf", new Date());
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		List<User> list2 = mapper.readValue(jsonStr, new TypeReference<List<User>>(){});
		for (User user : list2) {
			System.out.println(user);
		}
	}
	
}
