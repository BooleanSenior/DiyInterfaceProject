package com.cn.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cn.pojo.User;
import com.cn.service.UserService;
import com.cn.util.TopThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.service.MemberFeign;

import javax.annotation.Resource;


@RestController
public class OrderFeginController {
	@Autowired
	private MemberFeign memberFeign;

	@Resource
	private UserService userService;

	@RequestMapping("/getToOrderMemberAll")
	public List<String> getToOrderMemberAll() {
		System.out.println("order fegin 工程调用Analysis工程");
		return memberFeign.getToOrderMemberAll();
	}
	
	@RequestMapping("/getOrderInfo")
	public String getOrderInfo(){
		return "getOrderInfo";
	}


	@RequestMapping("/getUserOne")
	public  User getUserOne(String personal_id){
		return userService.getUserOne(personal_id);
	}

	@RequestMapping("/getUserLike")
	public String getUserLike(String area_code){
		String result = TopThread.springQuzeJob();
		//return userService.getUserLike(area_code);
		return result;
	}


	@RequestMapping("/getUser")
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
