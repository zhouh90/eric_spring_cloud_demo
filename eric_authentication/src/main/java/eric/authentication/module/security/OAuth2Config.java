package eric.authentication.module.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import eric.authentication.module.security.handler.fail.OauthWebResponseExceptionTranslator;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:19:47
 * @Description
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private TokenStore tokenStore;
//	@Autowired
//	private DefaultTokenServices tokenServices;
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

//	@Autowired
//	private TokenEnhancer jwtTokenEnhancer;
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new EricTokenEnhancer();
	}

	@Autowired
	private OauthWebResponseExceptionTranslator oauthWebResponseExceptionTranslator;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter));
		endpoints.tokenStore(tokenStore).accessTokenConverter(jwtAccessTokenConverter).tokenEnhancer(tokenEnhancerChain)
				.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
		endpoints.exceptionTranslator(oauthWebResponseExceptionTranslator);

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(new EricClientDetailService());
	}

}
