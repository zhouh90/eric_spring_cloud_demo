package eric.authentication.module.security.handler.fail;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午4:31:23
 * @Description
 */

@JsonSerialize(using = OauthExceptionSerializer.class)
public class OauthException extends OAuth2Exception {

	private static final long serialVersionUID = 1L;

	public OauthException(String msg) {
		super(msg);
	}

}
