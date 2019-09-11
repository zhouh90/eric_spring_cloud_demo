package eric.app1.framework.dto;

import eric.app1.framework.dto.enums.CodeEnum;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:24:59
 * @Description 统一接口返回类型
 */

public class Res<T> {

	/**
	 * 返回码
	 */
	private Integer code;
	/**
	 * 异常信息
	 */
	private String message;
	/**
	 * 接口数据
	 */
	private T data;

	public Res() {
	}

	public Res(CodeEnum code, T data) {
		this.code = code.getCode();
		this.message = code.getMessage();
		this.data = data;
	}

	public Res(CodeEnum code, T data, String message) {
		this.code = code.getCode();
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
