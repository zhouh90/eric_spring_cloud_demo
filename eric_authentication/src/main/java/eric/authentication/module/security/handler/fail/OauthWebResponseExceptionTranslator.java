package eric.authentication.module.security.handler.fail;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午4:36:13
 * @Description
 */

@Component
@Slf4j
public class OauthWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		log.info("登录失败");
		OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
		return ResponseEntity.status(HttpServletResponse.SC_OK)// oAuth2Exception.getHttpErrorCode()
				.body(new OauthException(oAuth2Exception.getMessage()));
	}

}
