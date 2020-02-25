package com.cn.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(value = "diy-UserService")
public interface MemberFeign {

	@RequestMapping("/getUser")
	public List<String> getUser();

}
