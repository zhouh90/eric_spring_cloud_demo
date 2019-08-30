package eric.framework.dto;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:24:59
 * @Description 统一接口返回类型
 */

public class R<T> {

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

	public R() {
	}

	public R(CodeEnum code, T data) {
		this.code = code.getCode();
		this.message = code.getMessage();
		this.data = data;
	}

	public R(CodeEnum code, T data, String message) {
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

	public enum CodeEnum {
		OK(200, "OK"), // 正常
		AUTHENTICATION_FAILED(401, "toekn失效，请重新登录"), AUTHORITIED_FAILED(403, "账号没有权限"), ERROR(999, "系统异常");
		private Integer code;
		private String message;

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

		private CodeEnum(Integer code, String message) {
			this.code = code;
			this.message = message;
		}
	}
}
