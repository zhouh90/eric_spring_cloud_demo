package eric;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 下午5:49:02
 * @Description
 */

@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

}
