package com.example.demo.vo;

import lombok.Getter;

public class ResultData<DT> {
<<<<<<< HEAD

=======
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	@Getter
	private String ResultCode;
	@Getter
	private String msg;
	@Getter
	private DT data1;
	@Getter
	private String data1Name;
<<<<<<< HEAD

	@Getter
	private Object data2;
=======
	@Getter
	private DT data2;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	@Getter
	private String data2Name;

	public static <DT> ResultData<DT> from(String ResultCode, String msg) {
		return from(ResultCode, msg, null, null);
	}

	public static <DT> ResultData<DT> from(String ResultCode, String msg, String data1Name, DT data) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.ResultCode = ResultCode;
		rd.msg = msg;
		rd.data1 = data;
		rd.data1Name = data1Name;

		return rd;
	}

<<<<<<< HEAD
=======
	public static <DT> ResultData<DT> from(String ResultCode, String msg, String data1Name, DT data1, String data2Name,
			DT data2) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.ResultCode = ResultCode;
		rd.msg = msg;
		rd.data1 = data1;
		rd.data1Name = data1Name;
		rd.data2 = data2;
		rd.data2Name = data2Name;

		return rd;
	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	public boolean isSuccess() {
		return ResultCode.startsWith("S-");
	}

<<<<<<< HEAD
	public boolean isFail() {
=======
	public boolean isfail() {
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		return isSuccess() == false;
	}

	public static <DT> ResultData<DT> newData(ResultData rd, String dataName, DT newData) {
		return from(rd.getResultCode(), rd.getMsg(), dataName, newData);
	}

<<<<<<< HEAD
	public static <DT> ResultData<DT> from(String resultCode, String msg, String data1Name, DT data1, String data2Name,
			DT data2) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.ResultCode = resultCode;
		rd.msg = msg;
		rd.data1Name = data1Name;
		rd.data1 = data1;
		rd.data2Name = data2Name;
		rd.data2 = data2;

		return rd;
	}
=======
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
