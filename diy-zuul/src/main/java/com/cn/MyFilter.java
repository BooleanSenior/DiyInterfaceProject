package com.cn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		String refer=request.getHeader("refer");


		// 这些是对请求头的匹配，网上有很多解释
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods","GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Allow-Headers","authorization, content-type");
		response.setHeader("Access-Control-Expose-Headers","X-forwared-port, X-forwarded-host");
		response.setHeader("Vary","Origin,Access-Control-Request-Method,Access-Control-Request-Headers");

		// 跨域请求一共会进行两次请求 先发送options 是否可以请求
		// 调试可发现一共拦截两次 第一次请求为options，第二次为正常的请求 eg：get请求
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())){
			ctx.setSendZuulResponse(false); //验证请求不进行路由
			ctx.setResponseStatusCode(HttpStatus.OK.value());//返回验证成功的状态码
			ctx.set("isSuccess", true);
			return null;
		}
		// 第二次请求（非验证，eg：get请求不会进到上面的if） 会走到这里往下进行
		// 不需要token认证
		ctx.setSendZuulResponse(true); //对请求进行路由
		ctx.setResponseStatusCode(HttpStatus.OK.value());
		ctx.set("isSuccess", true);
	//	return null;



		if (accessToken != null) {
			return null;
		}
		log.warn("token is empty");
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(401);
		try {
			ctx.getResponse().getWriter().write("token is empty");
		} catch (Exception e) {
		}
		return null;

	}
}
