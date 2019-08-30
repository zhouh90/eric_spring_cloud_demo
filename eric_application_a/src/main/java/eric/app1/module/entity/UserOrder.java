package eric.app1.module.entity;

import java.io.Serializable;
import java.util.Date;

import eric.app1.module.entity.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午5:03:15
 * @Description
 */
@Getter
@Setter
@ToString
public class UserOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private int id;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 订单状态
	 */
	private OrderStatusEnum orderStatus;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 订单更新时间
	 */
	private Date updateTime;

	/**
	 * 订单详情
	 */
	private UserOrderDetail orderDetail;

}
