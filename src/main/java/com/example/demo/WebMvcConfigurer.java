package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

<<<<<<< HEAD
import com.example.demo.interceptor.BeforeActionInterceptor;
import com.example.demo.interceptor.NeedLoginInterceptor;
import com.example.demo.interceptor.NeedLogoutInterceptor;
=======
import com.example.demo.Interceptor.BeforeActionInterceptor;
import com.example.demo.Interceptor.NeedLoginInterceptor;
import com.example.demo.Interceptor.NeedLogoutInterceptor;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

<<<<<<< HEAD
	// BeforeActionInterceptor 불러오기(연결)
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;

	// NeedLoginInterceptor 불러오기(연결)
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	// NeedLogoutInterceptor 불러오기(연결)
	@Autowired
	NeedLogoutInterceptor needLogoutInterceptor;

	// 인터셉터 등록(적용)
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
//				.excludePathPatterns("/error");
//
//		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/write")
//				.addPathPatterns("/usr/article/doWrite").addPathPatterns("/usr/article/modify")
//				.addPathPatterns("/usr/article/doModify").addPathPatterns("/usr/article/doDelete")
//				.addPathPatterns("/usr/member/doLogout");
//
//		registry.addInterceptor(needLogoutInterceptor).addPathPatterns("/usr/member/login")
//				.addPathPatterns("/usr/member/doLogin").addPathPatterns("/usr/member/join")
//				.addPathPatterns("/usr/member/doJoin");

		InterceptorRegistration ir;

=======
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
		
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.addPathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
<<<<<<< HEAD

//		로그인 필요
		ir = registry.addInterceptor(needLoginInterceptor);
//		글 관련
		ir.addPathPatterns("/usr/article/write");
		ir.addPathPatterns("/usr/article/doWrite");
		ir.addPathPatterns("/usr/article/modify");
		ir.addPathPatterns("/usr/article/doModify");
		ir.addPathPatterns("/usr/article/doDelete");

//		회원관련
		ir.addPathPatterns("/usr/member/myPage");
		ir.addPathPatterns("/usr/member/checkPw");
		ir.addPathPatterns("/usr/member/doCheckPw");
		ir.addPathPatterns("/usr/member/doLogout");
		ir.addPathPatterns("/usr/member/modify");
		ir.addPathPatterns("/usr/member/doModify");

//		댓글 관련
		ir.addPathPatterns("/usr/reply/doWrite");

//		좋아요 싫어요
		ir.addPathPatterns("/usr/reactionPoint/doGoodReaction");
		ir.addPathPatterns("/usr/reactionPoint/doBadReaction");

//		로그아웃 필요
		ir = registry.addInterceptor(needLogoutInterceptor);
		ir.addPathPatterns("/usr/member/login");
		ir.addPathPatterns("/usr/member/doLogin");
		ir.addPathPatterns("/usr/member/join");
		ir.addPathPatterns("/usr/member/doJoin");
		ir.addPathPatterns("/usr/member/findLoginId");
		ir.addPathPatterns("/usr/member/doFindLoginId");
		ir.addPathPatterns("/usr/member/findLoginPw");
		ir.addPathPatterns("/usr/member/doFindLoginPw");

	}

=======
		
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
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
