package eric.authentication.module.security;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:21:03
 * @Description
 */

public class EricTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> additionalInfo = new HashMap<>();
		// 需要额外的用户数据可以在这里增加
		UserAuthentication userAuthentication = (UserAuthentication) authentication.getUserAuthentication()
				.getPrincipal();
		additionalInfo.put("id", userAuthentication.getId());
		additionalInfo.put("loginName", userAuthentication.getUsername());
		additionalInfo.put("nickName", userAuthentication.getNickName());
		additionalInfo.put("requestTime", LocalDate.now());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
