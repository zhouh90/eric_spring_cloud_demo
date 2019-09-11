package eric;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:10:44
 * @Description 认证服务启动类
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@MapperScan(basePackages = "eric.authentication.module.mapper")
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
