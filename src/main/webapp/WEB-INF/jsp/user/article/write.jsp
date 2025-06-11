<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="ARTICLE WRITE"></c:set>
<%@ include file="../common/head.jspf"%>

<section class="mt-8 text-xl px-4">
	<div class="mx-auto">

		<form action="../article/doWrite" method="POST">

			<table class="table" border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">
				<tbody>
					<tr>
						<th style="text-align: center;">아이디</th>
						<td style="text-align: center;">${article.id }</td>
					</tr>
					<tr>
						<th style="text-align: center;">게시판</th>
						<td style="text-align: center;">
							<select name="boardId" class="select select-sm select-ghost">
								<option value="" selected disabled>게시판을 선택해주세요</option>
								<option value="1">공지사항</option>
								<option value="2">자유</option>
								<option value="3">QnA</option>
							</select>
						</td>

					</tr>
					<tr>
						<th style="text-align: center;">제목</th>
						<td style="text-align: center;">
							<input type="text" class="input input-secondary input-md" required="required" name="title" autocomplete="off"
								placeholder="제목" />
						</td>

					</tr>

					<tr>
						<th style="text-align: center;">내용</th>
						<td style="text-align: center;">
							<textarea style="text-align: center;" type="text" placeholder="내용 입력" name="body"></textarea>
						</td>
					</tr>

					<tr>
						<th></th>
						<td style="text-align: center;">
							<input value="작성" type="submit" />
						</td>
					</tr>

				</tbody>
			</table>

		</form>

		<div class="btns">
			<button type="button" onclick="history.back();">뒤로가기</button>

		</div>
	</div>
</section>



<%@ include file="../common/foot.jspf"%>