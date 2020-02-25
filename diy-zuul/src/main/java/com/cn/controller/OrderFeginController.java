package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class OrderFeginController {

	@RequestMapping("/getUserZuul")
	@ResponseBody
	public String getUser(String username,String password){
		//List list = userService.findAll();
		/*List<String> list = new ArrayList<String>();
		User user = new User();
		user.setAddress("河北省");
		user.setAge(28);
		user.setCardNum("130422588788894455");

		list.add(user.toString());*/

		return "1";
	}



}
