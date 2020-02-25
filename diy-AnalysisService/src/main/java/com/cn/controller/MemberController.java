package com.cn.controller;

import java.util.ArrayList;
import java.util.List;

import com.cn.service.MemberFeign;
import com.cn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MemberController {

	@Autowired
	private MemberFeign peopleServiceFeign;

	@Value("${server.port}")
	private String serverPort;

	@Resource
	private UserService userService;




	@RequestMapping("/getMemberAll")
	public List<String> getMemberAll() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("zhangsan");
		listUser.add("lisi");
		listUser.add("wangwu");
		listUser.add("serverPort:" + serverPort);
		return listUser;
	}

	@RequestMapping("/getMemberServiceApi")
	public String getOrderServiceApi(){
		return "this is order 会员服务工程";
	}

	@RequestMapping("/getUserMy")
	@ResponseBody
	public List getUserMy(){
		List list = userService.findAll();
		return list;
	}

	@RequestMapping("/getUser")
	public  List<String> getUser(){
		return 	peopleServiceFeign.getUser();
	}

}
