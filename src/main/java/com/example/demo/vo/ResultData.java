package com.example.demo.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	private String ResultCode;
	@Getter
	private String msg;
	@Getter
	private Object data1;

	public static ResultData from(String ResultCode, String msg) {
		return from(ResultCode, msg, null);
	}

	public static ResultData from(String ResultCode, String msg, Object data) {
		ResultData rd = new ResultData();
		rd.ResultCode = ResultCode;
		rd.msg = msg;
		rd.data1 = data;

		return rd;
	}

	public boolean isSuccess() {
		return ResultCode.startsWith("S-");
	}

	public boolean isfail() {
		return isSuccess() == false;
	}

}
