package eric.app2.module.kafka.producer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import eric.app2.module.dto.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月26日 上午10:25:58
 * @Description
 */
@Component
@Slf4j
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send() {
		Message message = new Message();
		message.setBizId(System.currentTimeMillis());
		message.setMsgData("this is message data -- 这是消息 ");
		message.setSendTime(LocalDateTime.now());
		String messageJson = JSON.toJSONString(message);
		log.info("+++++++++++++++++++++  message = {}", messageJson);
		kafkaTemplate.send("test", messageJson);
	}
}
