package eric.app1.module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午8:49:58
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("")
	public String test() {
		return "test---appA---port:" + serverPort;
	}

}
