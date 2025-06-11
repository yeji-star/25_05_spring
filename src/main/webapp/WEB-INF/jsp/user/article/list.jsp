<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.code } LIST"></c:set>
<%@ include file="../common/head.jspf"%>


<section class="mt-24 text-xl px-4">
	<div class="mx-auto">
		<div class="mb-4 flex">
			<div>${articlesCount }개</div>
			<div class="flex-grow"></div>

			<!-- 검색창 -->

			<form action="">
				<input type="hidden" name="boardId" value="${param.boardId }">
				<div class="flex">
					<select class="select select-sm select-bordered max-w-xs" name="searchKeywordTypeCode"
						data-value="${param.searchKeywordTypeCode }">
						<option value="title">제목</option>
						<option value="body">내용</option>
						<option value="nickname">작성자</option>
					</select>
					<label class="input input-bordered input-sm flex items-center gap-2">
						<input type="text" placeholder="검색" name="searchKeyword" value="${param.searchKeyword }" />
						<button type="submit">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
								<!--!Font Awesome Free 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2025 Fonticons, Inc.-->
								<path
									d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z" /></svg>
						</button>
					</label>
				</div>
			</form>

			<%-- 			<div class="flex justify-end my-4">
				<table>
					<tr>
						<td>
							<select class="select select-sm" name="searchKeywordTypeCode">
								<option value="title">제목</option>
								<option value="body">내용</option>
								<option value="nickname">작성자</option>
							</select>
						</td>
						<td>
							<input type="text" class="input-sm" placeholder="검색어 입력" name="searchKeyword">
						</td>
						<td>
							<c:if test=""></c:if>
							<a class="btn btn-sm"
								href="list?boardId=${boardId}&searchKeywordTypeCode=${searchKeywordTypeCode }&searchKeyword=${searchKeyword }">검색</a>
						</td>
					</tr>
				</table>
			</div> --%>
		</div>


		<!-- search input에다가 btn 앞에잇는 건 select고  -->



		<table class="table glass" border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">

			<thead>

				<tr>
					<th style="text-align: center;">글 번호</th>
					<th style="text-align: center;">글쓴 날짜</th>
					<th style="text-align: center;">제목</th>
					<th style="text-align: center;">작성자</th>
					<th style="text-align: center;">조회수</th>
					<th style="text-align: center;">좋아요</th>
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
						<td style="text-align: center;">${article.hitCount }</td>
						<td style="text-align: center;">${article.extra__sumPoint }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>



	<!-- 	동적 페이징 -->
	<div class="flex justify-center mt-2">
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