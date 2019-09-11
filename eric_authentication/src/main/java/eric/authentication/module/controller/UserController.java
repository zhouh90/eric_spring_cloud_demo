package eric.authentication.module.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eric.authentication.framework.dto.R;
import eric.authentication.framework.dto.R.CodeEnum;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午3:15:13
 * @Description
 */

@RestController
public class UserController {

	@RequestMapping(value = "/user", produces = "application/json")
	public R<Object> user(OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
//		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return new R<Object>(CodeEnum.OK, userInfo);
	}

}
