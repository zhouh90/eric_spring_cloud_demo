package eric.authentication.module.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:23:46
 * @Description
 */

@Component
@Configuration
public class ServiceConfig {

	public String getJwtSigningKey() {
		return "hy67DtchJ9kjdhRy";
	}

}
