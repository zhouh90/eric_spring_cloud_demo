package eric;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月6日 下午1:17:29
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration
@RestController
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

	@RequestMapping("test")
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("code", 200);
		return map;
	}

}
