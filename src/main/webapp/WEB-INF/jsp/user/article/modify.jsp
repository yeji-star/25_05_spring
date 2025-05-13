<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="ARTICLE MODIFY"></c:set>
<%@ include file="../common/head.jspf"%>

<section class="mt-8 text-xl px-4">
	<div class="mx-auto">

		<form action="../article/doModify" method="MODIFY">

			<table border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">
				<tbody>
					<tr>
						<th style="text-align: center;">아이디</th>
						<td style="text-align: center;">${member.id}</td>
					</tr>
					<tr>
						<th style="text-align: center;">새 제목</th>
						<td style="text-align: center;">
							<input style="text-align: center;" type="text" placeholder="제목 입력" name="title" />
						</td>

					</tr>

					<tr>
						<th style="text-align: center;">새 내용</th>
						<td style="text-align: center;">
							<textarea style="text-align: center;" type="text" placeholder="내용 입력" name="body"></textarea>
						</td>
					</tr>

<!-- 					<tr>
						<th></th>
						<td style="text-align: center;">
							<input value="수정" type="submit" />
						</td>
					</tr> -->

				</tbody>
			</table>

		</form>

		<div class="btns">
			<button type="button" onclick="history.back();">뒤로가기</button>

				<a href="../article/doModify?id=${article.id}">수정</a>

		</div>
	</div>
</section>



<%@ include file="../common/foot.jspf"%>