package com.zxq.legao.entity.vo;

public class ResultVO<T> {
	private Integer code;
	private String msg;
	private T data;

	public ResultVO(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultVO(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultVO(T data) {
		this.data = data;
	}

	public <T> ResultVO success(T data) {
		return new ResultVO(200, "success", data);

	}
	public <T> ResultVO error(Integer code,String msg) {
		return new ResultVO( code,msg);

	}

}
