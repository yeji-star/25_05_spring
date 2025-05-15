<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.code } LIST"></c:set>
<%@ include file="../common/head.jspf"%>


<section class="mt-24 text-xl px-4">
	<div class="mx-auto">

		<div>${articlesCount }개</div>

		<!-- 검색창 -->

		<%-- 		<div class="container float-right m-2">
			<div class="row">
				<form method="post" name="search"
					action="list?&boardId=${boardId}&searchKeyword=${searchKeyword}&searchKeywordTypeCode=${searchKeywordTypeCode}">
					<table class="pull-right">
						<tr>
							<td>
								<select class="form-control select select-sm" name="searchField">
									<option disabled selected>검색</option>
									<option value="title">제목</option>
									<option value="body">내용</option>
									<option value="nickname">작성자</option>
								</select>
							</td>
							<td>
								<input type="text" class="form-control input-sm" placeholder="검색어 입력" name="searchText" maxlength="100">
							</td>
							<td>
								<button type="submit" class="btn btn-accent btn-sm">검색</button>
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div> --%>


		<table class="table glass" border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">

			<thead>

				<tr>
					<th style="text-align: center;">글 번호</th>
					<th style="text-align: center;">글쓴 날짜</th>
					<th style="text-align: center;">제목</th>
					<th style="text-align: center;">글쓴이</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${articles }">
					<tr class="hover:bg-base-300">
						<td style="text-align: center;">${article.id}</td>
						<td style="text-align: center;">${article.regDate.substring(0,10)}</td>
						<td style="text-align: center;">
							<a class="hover:underline" href="detail?id=${article.id }">${article.title }</a>
						</td>
						<td style="text-align: center;">${article.extra__writer }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>
	<!-- 	동적 페이징 -->
	<div class="flex justify-center mt-4">
		<div class="btn-group join ">
			<c:set var="paginationLen" value="3" />
			<c:set var="startPage" value="${page - paginationLen >= 1 ? page - paginationLen : 1 }" />
			<c:set var="endPage" value="${page + paginationLen <= pagesCount ? page + paginationLen : pagesCount}" />

			<!-- baseUri 변수 선언 -->
			<c:set var="baseUri" value="?boardId=${boardId }"></c:set>
			<c:set var="baseUri" value="${baseUri }&searchKeywordTypeCode=${searchKeywordTypeCode }"></c:set>
			<c:set var="baseUri" value="${baseUri }&searchKeyword=${searchKeyword }"></c:set>

			<c:if test="${startPage > 1}">
				<a class="join-item btn btn-sm" href="${baseUri }&page=1">1</a>
			</c:if>

			<c:if test="${startPage > 2}">
				<button class="join-item btn btn-sm btn-disabled">...</button>
			</c:if>


			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<a class="join-item btn btn-sm ${param.page == i ? 'btn-active' : ''}" href="${baseUri }&page=${i }">${i }</a>
			</c:forEach>

			<c:if test="${endPage < pagesCount - 1}">
				<button class="join-item btn-sm btn btn-disabled">...</button>
			</c:if>

			<c:if test="${endPage < pagesCount}">
				<a class="join-item btn btn-sm" href="${baseUri }&page=${pagesCount }">${pagesCount }</a>
			</c:if>
		</div>
	</div>

	<%-- 	<!-- 직관적인 페이징 -->
	<div class="flex justify-center mt-4">
		<div class="btn-group join">

			<c:forEach begin="1" end="${pagesCount }" var="i">

				<a class="join-item btn btn-sm ${param.page == i ? 'btn-active' : ''}" href="?page=${i }&boardId=${param.boardId }">${i }</a>
			</c:forEach>
		</div>
	</div> --%>

</section>



<%@ include file="../common/foot.jspf"%>