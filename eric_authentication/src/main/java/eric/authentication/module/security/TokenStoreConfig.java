package eric.authentication.module.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:22:05
 * @Description
 */

@Configuration
public class TokenStoreConfig {

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private RedisConnectionFactory connectionFactory;

	@Bean
	public TokenStore tokenStore() {
		EricRedisTokenStore redisTokenStore = new EricRedisTokenStore(connectionFactory);
		return redisTokenStore;
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(serviceConfig.getJwtSigningKey());
		return converter;
	}

}
