package eric.app1.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午10:05:59
 * @Description
 */

@Configuration
public class GlobalConfigs {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	/**
	 * 显示声明CommonsMultipartResolver为mutipartResolver
	 */
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// resolver.setDefaultEncoding("UTF-8");
		// resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
		resolver.setResolveLazily(true);
		resolver.setMaxInMemorySize(40960);
		resolver.setMaxUploadSize(3 * 1024 * 1024);// 上传文件大小 3M 3*1024*1024
		return resolver;
	}

}
