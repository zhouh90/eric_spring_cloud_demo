package eric.app1.framework.dto.enums;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月29日 上午9:50:22
 * @Description
 */

public enum CodeEnum {

	OK(200, "OK"),

	AUTHENTICATION_FAILED(401, "toekn失效，请重新登录"),

	AUTHORITIED_FAILED(403, "账号没有权限"),

	ERROR(999, "系统异常");

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
