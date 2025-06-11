<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../common/head.jspf" %>

<h1>FAQ</h1>

<div>
    <input class="input input-sm input-error" type="text" id="questionInput" placeholder="질문을 입력하세요" style="width: 300px;">
    <button class="btn btn-sm btn-soft btn-primary" onclick="ask()">질문하기</button>
</div>

<div id="answerBox" style="margin-top: 20px; display: none;">
    <h3>답변</h3>
    <div id="answerArea" style="border: 1px solid #ccc; padding: 10px;"></div>
</div>

<script>
function ask() {
    const question = $('#questionInput').val();

    if (!question.trim()) {
        alert("질문을 입력해주세요.");
        return;
    }

    $.ajax({
        url: '/user/faq/ask',
        type: 'POST',
        data: { question },
        dataType: 'json',
        success: function(data) {
            if (data.resultCode.startsWith('S-')) {
                $('#answerArea').html(data.data1);
                $('#answerBox').show();
            } else {
                $('#answerArea').html(data.msg);
                $('#answerBox').show();
            }
        },
        error: function() {
            alert("서버 오류가 발생했습니다.");
        }
    });
}
</script>

<%@ include file="../common/foot.jspf" %>