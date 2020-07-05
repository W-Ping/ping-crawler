package com.edu.ping.pingcrawler.pojo.res;

import java.io.Serializable;

/**
 * @author lwp
 * @create 2020/07/04 19:47
 */

public class ResultRes implements Serializable {
	public static final String SUCCESS_CODE = "success";
	public static final String FAIL_CODE = "fail";
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Object obj;


	public final static ResultRes success(Object obj) {
		return success(null, obj);
	}

	public final static ResultRes success(String message, Object obj) {
		ResultRes resultRes = new ResultRes();
		resultRes.setCode(SUCCESS_CODE);
		resultRes.setObj(obj);
		resultRes.setMessage(message);
		return resultRes;
	}

	public final static ResultRes fail(String message) {
		return fail(message, null);
	}

	public final static ResultRes fail(String message, Object object) {
		ResultRes resultRes = new ResultRes();
		resultRes.setCode(FAIL_CODE);
		resultRes.setObj(object);
		return resultRes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(final Object obj) {
		this.obj = obj;
	}
}
