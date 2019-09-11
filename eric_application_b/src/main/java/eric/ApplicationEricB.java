package eric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eric.app2.module.kafka.producer.KafkaSender;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月6日 下午2:28:11
 * @Description
 */

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationEricB {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEricB.class, args);
	}

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "test---appB" + serverPort;
	}

	@Autowired
	private KafkaSender sender;

	@RequestMapping(value = "sendMsg", method = RequestMethod.GET)
	public String sendMsg() {
		sender.send();
		return "OK";
	}

}
