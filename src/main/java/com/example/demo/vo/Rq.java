package com.example.demo.vo;

import java.io.IOException;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
<<<<<<< HEAD

import com.example.demo.service.MemberService;
=======
import org.springframework.stereotype.Service;

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.util.Ut;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
=======
// 로그인 총괄 담당

//Before~~를 바꿔서 등록을 한번 해줌 (얘만 하면 오류가 다른 게 나기 때문에 후처리필요)
// 그래서 Scope~~ 를 써야함
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class Rq {

	private final HttpServletRequest req;
	private final HttpServletResponse resp;
	private final HttpSession session;

	private boolean isLogined = false;
<<<<<<< HEAD
	private int loginedMemberId = 0;

	@Getter
	private Member loginedMember;

	public Rq(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
=======

	private int loginedMemberId = 0;

	public Rq(HttpServletRequest req, HttpServletResponse resp) {
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		this.req = req;
		this.resp = resp;
		this.session = req.getSession();

		if (session.getAttribute("loginedMemberId") != null) {
<<<<<<< HEAD
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginedMemberId);
=======

			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		}

		this.req.setAttribute("rq", this);
	}

	public void printHistoryBack(String msg) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
<<<<<<< HEAD
		println("<script>");
		if (!Ut.isEmpty(msg)) {
			println("alert('" + msg.replace("'", "\\'") + "');");
		}
		println("history.back();");
		println("</script>");
		resp.getWriter().flush();
		resp.getWriter().close();
=======

		println("<script>");

		if (!Ut.isEmpty(msg)) {
			println("alert('" + msg.replace("'", "\\'") + "');");

		}

		println("history.back()");
		println("</script>");
		resp.getWriter().flush();
		resp.getWriter().close();

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	private void println(String str) throws IOException {
		print(str + "\n");
<<<<<<< HEAD
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	private void print(String str) throws IOException {
		resp.getWriter().append(str);
<<<<<<< HEAD
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public void logout() {
		session.removeAttribute("loginedMemberId");
<<<<<<< HEAD
		session.removeAttribute("loginedMember");
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public void login(Member member) {
		session.setAttribute("loginedMemberId", member.getId());
<<<<<<< HEAD
		session.setAttribute("loginedMember", member);
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public void initBeforeActionInterceptor() {
		System.err.println("initBeforeActionInterceptor 실행됨");
<<<<<<< HEAD
	}

	public String historyBackOnView(String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		return "usr/common/js";
	}

	public String getCurrentUri() {
		String currentUri = req.getRequestURI();
		String queryString = req.getQueryString();

		System.out.println(currentUri);
		System.out.println(queryString);

		if (currentUri != null && queryString != null) {
			currentUri += "?" + queryString;
		}

		return currentUri;
	}
	
	public void printReplace(String resultCode, String msg, String replaceUri) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		print(Ut.jsReplace(resultCode, msg, replaceUri));
	}

	public String getEncodedCurrentUri() {
		return Ut.getEncodedCurrentUri(getCurrentUri());
	}
	
	public String getLoginUri() {
		return "../member/login?afterLoginUri=" + getAfterLoginUri();
	}

	private String getAfterLoginUri() {
		return getEncodedCurrentUri();
	}
	
	public String getFindLoginIdUri() {
		return "../member/findLoginId?afterFindLoginIdUri=" + getAfterFindLoginIdUri();
	}

	private String getAfterFindLoginIdUri() {
		return getEncodedCurrentUri();
	}

	public String getFindLoginPwUri() {
		return "../member/findLoginPw?afterFindLoginPwUri=" + getAfterFindLoginPwUri();
	}

	private String getAfterFindLoginPwUri() {
		return getEncodedCurrentUri();
	}
=======

	}

	public String historyBackOnView(String msg) {
		req.setAttribute("msq", msg);
		req.setAttribute("historyBack", true);
		return "user/common/js";
	}
	
	public String getCurrentUri() {
		String currentUri = req.getRequestURI();
		String queryString = req.getQueryString();
		
		System.out.println(currentUri);
		System.out.println(queryString);
		
		if(currentUri != null && queryString != null) {
			currentUri += "?" + queryString;
		}
		
		return currentUri;
	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
