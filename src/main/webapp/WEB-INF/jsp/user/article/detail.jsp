<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="ARTICLE DETAIL"></c:set>
<%@ include file="../common/head.jspf"%>

<!-- 변수 -->

<script>
	const params = {};
	params.id = parseInt('${param.id}');
	
	var isAlreadyAddGoodRp = ${isAlreadyAddGoodRp};
	var isAlreadyAddBadRp = ${isAlreadyAddBadRp};
</script>

<!-- 좋아요 싫어요 -->
<script>
/* 좋아요 싫어요 버튼 */
 function checkRP() {
	if(isAlreadyAddGoodRp == true) {
		$('#likeButton').toggleClass('btn-outline');
	} else if (isAlreadyBadRp == true) {
		$('#DislikeButton').toggleClass('btn-outline');
	} else {
		return;
	}
}
 
 function doGoodReaction(articleId) {
	$.ajax({
		url: 'user/reactionPoint/doGoodReaction',
		type: 'POST',
		data: {
			relTypeCode: 'article',
			relId: articleId
		},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			console.log('data.data1Name : ' + data.data1Name);
			console.log('data.data1 : ' + data.data1);
			console.log('data.data2Name : ' + data.data2Name);
			console.log('data.data2 : ' + data.data2);
			
			if(data.resultCode.startsWith('S-')) {
				var likeButton = $('#likeButton');
				var likeCount = $('#likeCount');
				var likeCountC = $('.likeCount');				
				var DislikeButton = $('#DislikeButton');
				var DislikeCount = $('#DislikeCount');
				var DislikeCountC = $('.DislikeCount');
				
				if (data.resultCode == 'S-1') {
					likeButton.toggleClass('btn-outline');
					likeCount.text(data.data1);
					likeCountC.text(data.data1);
				} else if (data.resultCode == 'S-2') {
					DislikeButton.toggleClass('btn-outline');
					DislikeCount.text(data.data2);
					DislikeCountC.text(data.data2);
					
					likeButton.toggleClass('btn-outline');
					likeCount.text(data.data1);
					likeCountC.text(data.data1);
				} else {
					likeButton.toggleClass('btn-outline');
					likeCount.text(data.data1);
					likeCountC.text(data.data1);
				}
			} else {
				alert(data.msg);
			}
		},
		error: function(jdXHR, textStatus, errorThrown) {
			alert('좋아요 오류 발생 : ' + textStatus);
		}
	});
}
 
 function doBadReaction(articleId) {
		$.ajax({
			url: 'user/reactionPoint/doBadReaction',
			type: 'POST',
			data: {
				relTypeCode: 'article',
				relId: articleId
			},
			dataType: 'json',
			success: function(data) {
				console.log(data);
				console.log('data.data1Name : ' + data.data1Name);
				console.log('data.data1 : ' + data.data1);
				console.log('data.data2Name : ' + data.data2Name);
				console.log('data.data2 : ' + data.data2);
				
				if(data.resultCode.startsWith('S-')) {
					var likeButton = $('#likeButton');
					var likeCount = $('#likeCount');
					var likeCountC = $('.likeCount');
					
					var DislikeButton = $('#DislikeButton');
					var DislikeCount = $('#DislikeCount');
					var DislikeCountC = $('.DislikeCount');
					
					if (data.resultCode == 'S-1') {
						DislikeButton.toggleClass('btn-outline');
						DislikeCount.text(data.data2);
						DislikeCountC.text(data.data2);
						
					} else if (data.resultCode == 'S-2') {						
						likeButton.toggleClass('btn-outline');
						likeCount.text(data.data1);
						likeCountC.text(data.data1);
						
						DislikeButton.toggleClass('btn-outline');
						DislikeCount.text(data.data2);
						DislikeCountC.text(data.data2);
					} else {
						DislikeButton.toggleClass('btn-outline');
						DislikeCount.text(data.data2);
						DislikeCountC.text(data.data2);
					}
				} else {
					alert(data.msg);
				}
			},
			error: function(jdXHR, textStatus, errorThrown) {
				alert('싫어요 오류 발생 : ' + textStatus);
			}
		});
	}
 
 $(function() {
	checkRP();
})

</script>

<script>
function ArticleDetail__doIncreaseHitCount() {
	
	/* 브라우저에서 관리하는 저장소 */
	
	const localStorageKey = 'article__' + param.id + '__alreadyOnView';
	
	if(localStorage.getItem(localStorageKey)) {
		return;
	}
	
	localStorage.setItem(localStorageKey, true);
	
	$.get('../article/doIncreaseHitCountRd', {
		id : params.id,
		ajaxMode : 'Y'
	}, function(data) {
		console.log(data);
		console.log(data.data1);
		console.log(data.msg);
		$('.article-detail__hit-count').html(data.data1);
	}, 'json');
}

$(function() {
	ArticleDetail__doIncreaseHitCount();
	/* setTimeout( ArticleDetail__doIncreaseHitCount(), 2000); */
})



</script>


<section class="mt-24 text-xl px-4">
	<div class="mx-auto">

		<div class="btns">
			<button class="btn btn-ghost" type="button" onclick="history.back();">뒤로가기</button>
			<c:if test="${article.userCanDelete }">
				<a class="btn btn-ghost float-right" href="../article/doDelete?id=${article.id}">삭제</a>
			</c:if>
			<c:if test="${article.userCanModify }">
				<a class="btn btn-ghost float-right" href="../article/modify?id=${article.id}">수정</a>
			</c:if>

		</div>

		<table class="table" border="1" cellspacing="0" cellpadding="5" style="width: 100%; border-collapse: collapse;">
			<tbody>
				<tr>
					<th style="text-align: center;">글 번호</th>
					<td style="text-align: center;">${article.id}</td>
				</tr>
				<tr>
					<th style="text-align: center;">글쓴 날짜</th>
					<td style="text-align: center;">${article.regDate}</td>
				</tr>
				<tr>
					<th style="text-align: center;">수정 날짜</th>
					<td style="text-align: center;">${article.updateDate}</td>
				</tr>
				<tr>
					<th style="text-align: center;">조회수</th>
					<td style="text-align: center;">
						<span class="article-detail__hit-count"> ${article.hitCount } </span>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">좋아요 / 싫어요 / ${usersReaction }</th>
					<td style="text-align: center;">
						<button id="likeButton" class="btn btn-outline btn-info" onclick="doGoodReaction(${param.id})">
							좋아요
							<span class="likeCount">${article.goodReactionPoint }</span>
						</button>

						<button id="DislikeButton" class="btn btn-outline btn-secondary" onclick="doBadReaction(${param.id})">
							싫어요
							<span class="DislikeCount">${article.badReactionPoint }</span>
						</button>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">작성자</th>
					<td style="text-align: center;">${article.extra__writer }</td>
				</tr>
				<tr>
					<th style="text-align: center;">게시판 번호</th>
					<td style="text-align: center;">${article.boardId }</td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td style="text-align: center;">${article.title }</td>
				</tr>
				<tr>
					<th style="text-align: center;">내용</th>
					<td style="text-align: center;">${article.body }</td>
				</tr>
			</tbody>
		</table>

		<div>

			<div class="comment btns mt-20 mb-20">
				<form action="../writeComment" method="post">
					<fieldset>
						<legend class="fieldset-legend">댓글</legend>
						<textarea style="text-align: center;" type="text" placeholder="댓글 입력" name="text"></textarea>
						<c:if test="${article.userCanDelete }">
							<a class="btn btn-ghost float-right" href="../article/doDelete?id=${article.id}">삭제</a>
						</c:if>
						<c:if test="${article.userCanModify }">
							<a class="btn btn-ghost float-right" href="../article/modify?id=${article.id}">수정</a>
						</c:if>
						<button type="submit">등록</button>
					</fieldset>
				</form>
			</div>

		</div>
		
		<tr>
			<th style="text-align: center;">조회수</th>
			<td style="text-align: center;">
				<span class="article-detail__hit-count"> ${article.hitCount } </span>
			</td>
		</tr>

	</div>
</section>



<%@ include file="../common/foot.jspf"%>