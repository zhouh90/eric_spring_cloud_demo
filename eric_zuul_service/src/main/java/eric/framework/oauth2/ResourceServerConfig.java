package eric.framework.oauth2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.csrf.CsrfFilter;

import eric.framework.filters.CorsFilter;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午10:29:05
 * @Description
 */
//Order值越小优先级越高
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Resource
	private CorsFilter corsFilter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().addFilterBefore(corsFilter, CsrfFilter.class);
		http
//		.apply(permitAllSecurityConfig).and()
				.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();

		http.authorizeRequests().antMatchers(PermitUrls.swaggerUrls).permitAll();// 允许匿名访问
		http.authorizeRequests().antMatchers(PermitUrls.permitUrls).permitAll()// 允许匿名访问
				.anyRequest().authenticated()// 除上面外的所有请求全部需要鉴权认证
				.and().httpBasic();
		// 禁用缓存
		http.headers().cacheControl();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resource) throws Exception {
		resource.authenticationEntryPoint(new AuthExceptionEntryPoint());
//		resource.accessDeniedHandler(new AuthAccessDeniedHandler());
	}

}
