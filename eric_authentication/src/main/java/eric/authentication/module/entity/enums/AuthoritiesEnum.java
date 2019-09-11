package eric.authentication.module.entity.enums;

import lombok.AllArgsConstructor;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月21日 下午3:44:06
 * @Description
 */
@AllArgsConstructor
public enum AuthoritiesEnum {

	ADMIN("ROLE_ADMIN"),

	USER("ROLE_USER"),

	ANONYMOUS("ROLE_ANONYMOUS");

	private String role;

	public String getRole() {
		return role;
	}

}
