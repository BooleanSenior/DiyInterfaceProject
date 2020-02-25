package com.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.service.OrderMemberService;



@RestController
public class OrderController {
	@Autowired
	private OrderMemberService orderMemberService;

	@RequestMapping("/getOrderUserAll")
	public List<String> getOrderUserAll() {
		System.out.println("订单服务开始调用会员服务");
		return orderMemberService.getOrderUserAll();

	}

	@RequestMapping("/getOrderServiceApi")
	public String getOrderServiceApi(){
		return "this is order 服务工程";
	}

}
