package eric.app2.module.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月26日 上午9:50:56
 * @Description
 */
@Getter
@Setter
@ToString
public class Message {

	private long bizId;

	private String msgData;

	private LocalDateTime sendTime;

}
