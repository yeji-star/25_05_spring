package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
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
//		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**"); // 모든 요청이 들어오기 전에 befor 인터셉터 활용하겠다
//
//		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/user/article/write")
//				.addPathPatterns("/user/article/doWrite").addPathPatterns("/user/article/modify")
//				.addPathPatterns("/user/article/doModify").addPathPatterns("/user/article/doDelete")
//				.addPathPatterns("/user/member/doLogout").addPathPatterns("user/reactionPoint/doGoodReaction");
//
//		registry.addInterceptor(needLogoutInterceptor).addPathPatterns("/user/member/login")
//				.addPathPatterns("/user/member/doLogin").addPathPatterns("/user/member/join")
//				.addPathPatterns("/user/member/doJoin");

		InterceptorRegistration ir;
		
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.addPathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
		
		ir = registry.addInterceptor(needLoginInterceptor);
		ir.addPathPatterns("/user/article/write");
		ir.addPathPatterns("/user/article/doWrite");
		ir.addPathPatterns("/user/article/modify");
		ir.addPathPatterns("/user/article/doModify");
		ir.addPathPatterns("/user/article/doDelete");
		ir.addPathPatterns("/user/member/doLogout");
		
		
		ir.addPathPatterns("user/reactionPoint/doGoodReaction");
		ir.addPathPatterns("user/reactionPoint/doBadReaction");
		ir.addPathPatterns("user/comment");
		
		ir = registry.addInterceptor(needLogoutInterceptor);
		ir.addPathPatterns("/user/member/login");
		ir.addPathPatterns("/user/member/doLogin");
		ir.addPathPatterns("/user/member/join");
		ir.addPathPatterns("/user/member/doJoin");
	}
}
