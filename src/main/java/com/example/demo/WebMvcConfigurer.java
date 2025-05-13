package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.demo.Interceptor.BeforeActionInterceptor;
import com.example.demo.Interceptor.NeedLoginInterceptor;
import com.example.demo.Interceptor.NeedLogoutInterceptor;

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

	// BeforeActionInterceptor 연결
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;

	// needLoginInterceptor 연결
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	// needLogoutInterceptor 연결
	@Autowired
	NeedLogoutInterceptor needLogoutInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**"); // 모든 요청이 들어오기 전에 befor 인터셉터 활용하겠다

		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/user/article/write")
				.addPathPatterns("/user/article/doWrite").addPathPatterns("/user/article/modify")
				.addPathPatterns("/user/article/doModify").addPathPatterns("/user/article/doDelete")
				.addPathPatterns("/user/member/doLogout");

		registry.addInterceptor(needLogoutInterceptor).addPathPatterns("/user/member/login")
				.addPathPatterns("/user/member/doLogin").addPathPatterns("/user/member/join")
				.addPathPatterns("/user/member/doJoin");

	}
}
