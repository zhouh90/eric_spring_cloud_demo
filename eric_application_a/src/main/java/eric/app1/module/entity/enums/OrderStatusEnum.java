package eric.app1.module.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月16日 下午5:25:24
 * @Description
 */
@AllArgsConstructor
public enum OrderStatusEnum {

	/**
	 * 待付款
	 */
	WAIT_TO_PAY("待付款"),

	/**
	 * 配送中
	 */
	DISPATCHING("配送中"),

	/**
	 * 已签收
	 */
	FINISHED("已签收"),

	/**
	 * 签收并评论
	 */
	FINISHED_AND_EVALUATED("签收并评论");

	@Getter
	private String description;

}
