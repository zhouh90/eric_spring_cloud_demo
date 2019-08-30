package eric;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月6日 下午2:28:11
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan(basePackages = "eric.app1.module.mapper")
public class ApplicationEricA {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEricA.class, args);
	}

}
