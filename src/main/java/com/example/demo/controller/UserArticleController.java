package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DemoApplication;
import com.example.demo.service.ArticleService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;
import com.mysql.cj.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserArticleController {

	private final DemoApplication demoApplication;

	@Autowired
	private ArticleService articleService;

	UserArticleController(DemoApplication demoApplication) {
		this.demoApplication = demoApplication;
	}

	// 로그인 체크 -> 유무 체크 -> 권한체크

	// 생성(doAdd)했던 게시글'들' 출력

	@RequestMapping("/user/article/getArticles")
	@ResponseBody
	public ResultData<List<Article>> getArticles() {

		List<Article> articles = articleService.getArticles();
		return ResultData.from("S-1", "Article List", "게시글 리스트", articles);

	}

	// 단일 글만 보고 싶을 때

	@RequestMapping("/user/article/getArticle")
	@ResponseBody
	public ResultData<Article> getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시글은 없습니다.", id));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글입니다.", id), "게시글 1row", article);
	}

	// 상세 페이지

	@RequestMapping("/user/article/detail")
	public String showDetail(HttpServletRequest req, Model model, int id) {

		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

		model.addAttribute("article", article);

		return "user/article/detail";
	}

	// 글 리스트

	@RequestMapping("/user/article/list")
	public String showList(Model model) {

		List<Article> articles = articleService.getArticles();

		model.addAttribute("articles", articles);

		return "user/article/list";
	}

	// 데이터 삭제

	@RequestMapping("/user/article/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req, int id) {

		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return Ut.jsHistoryBack("F-1", Ut.f("%d번 글은 없습니다.", id));
		}

		ResultData userCanDeleteRd = articleService.userCanDelete(rq.getLoginedMemberId(), article);

		if (userCanDeleteRd.isfail()) {
			return Ut.jsHistoryBack(userCanDeleteRd.getResultCode(), userCanDeleteRd.getMsg());
		}

		if (userCanDeleteRd.isSuccess()) {
			articleService.deleteArticle(id);
		}

		return Ut.jsReplace(userCanDeleteRd.getResultCode(), userCanDeleteRd.getMsg(), "../article/list");
	}

	// 수정 폼 보여주기
	@RequestMapping("/user/article/modify")
	public String showModify() {
		return "/user/article/modify";
	}
	
	// 글 수정

	@RequestMapping("/user/article/doModify")
	@ResponseBody
	public ResultData doModify(HttpServletRequest req, int id, String title, String body) {

		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getArticleById(id);

		// 게시글 유무 체크
		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시글은 없습니다", id), "없는 글의 id", id);
		}

		// 수정할 수 있는 권한 체크
		ResultData userCanModifyRd = articleService.userCanModify(rq.getLoginedMemberId(), article);

		if (userCanModifyRd.isfail()) {
			return userCanModifyRd;
		}

		if (userCanModifyRd.isSuccess()) {
			articleService.modifyArticle(id, title, body);
		}

		article = articleService.getArticleById(id);

		return ResultData.from(userCanModifyRd.getResultCode(), userCanModifyRd.getMsg(), "수정된 글", article);
	}
	
	// 글쓰기 폼 보여주기
	@RequestMapping("/user/article/write")
	public String showWrite() {
		return "/user/article/write";
	}

	// 글쓰기

	@RequestMapping("/user/article/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest req, String title, String body) {

		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isEmptyOrNull(title)) {
			return Ut.jsHistoryBack("F-1", "제목을 입력하세요.");
		}

		if (Ut.isEmptyOrNull(body)) {
			return Ut.jsHistoryBack("F-2", "내용을 입력하세요.");
		}

		ResultData doWriteRd = articleService.writeArticle(rq.getLoginedMemberId(), title, body);

		int id = (int) doWriteRd.getData1();

		Article article = articleService.getArticleById(id);

		return Ut.jsReplace("S-1", Ut.f("%d번 글이 작성됐습니다.", article.getId()), "../article/list");

	}
}
