<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="MEMBER LOGIN"></c:set>
<%@ include file="../common/head.jspf"%>


<section class="mt-8 text-xl px-4">
	<div class="mx-auto">
		<form action="../member/doLogin" method="POST">
			<table class="table" border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">


				<tbody>

					<tr>
						<th>아이디</th>
						<td style="text-align: center;">
							<input name="loginId" autocomplete="off" type="text" class="input input-sm" placeholder="아이디 입력" />
						</td>
					</tr>

					<tr>
						<th>비밀번호</th>
						<td style="text-align: center;">
							<input name="loginPw" autocomplete="off" type="text" class="input input-sm" placeholder="비밀번호 입력" />
						</td>
					</tr>
					
					<tr>
						<th></th>
						<td style="text-align: center;">
							<input value="로그인" type="submit" class="input input-accent input-sm hover:bg-base-300"  />
						</td>
					</tr>

				</tbody>
			</table>
		</form>
		<div class="btns">
			<button class="btn btn-sm btn-ghost" type="button" onclick="history.back();">뒤로가기</button>
			<a class="btn btn-sm btn-ghost float-right" href="../member/join">회원가입</a>
		</div>
	</div>
</section>



<%@ include file="../common/foot.jspf"%>