package eric.authentication.module.security;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:05:48
 * @Description
 */

public class EricClientDetailService implements ClientDetailsService {

	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	public static void main(String[] args) {
//		System.out.println(new EricClientDetailService().passwordEncoder().encode("123"));
//	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		BaseClientDetails client = null;
		if ("eric-web".equals(clientId)) {
			client = new BaseClientDetails();
			client.setClientId(clientId);
			client.setClientSecret(passwordEncoder().encode("er5tsw9ivofg2qs"));
			client.setAuthorizedGrantTypes(Arrays.asList("password", "refresh_token"));
			client.setScope(Arrays.asList("all"));
			client.setAuthorities(AuthorityUtils.createAuthorityList("user_role"));
			client.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(2));
			client.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
		}
		if ("eric-app".equals(clientId)) {
			client = new BaseClientDetails();
			client.setClientId(clientId);
			client.setClientSecret(passwordEncoder().encode("r56yiaj7f62hfov"));
			client.setAuthorizedGrantTypes(Arrays.asList("password", "refresh_token"));
			client.setScope(Arrays.asList("all"));
			client.setAuthorities(AuthorityUtils.createAuthorityList("user_role"));
			client.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(7));
			client.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
		}
		if (client == null) {
			throw new NoSuchClientException("No client with clientId: " + clientId);
		}
		return client;
	}

}
