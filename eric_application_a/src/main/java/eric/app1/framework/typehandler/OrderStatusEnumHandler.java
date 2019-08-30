package eric.app1.framework.typehandler;

import eric.app1.module.entity.enums.OrderStatusEnum;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月16日 下午5:25:37
 * @Description
 */

public class OrderStatusEnumHandler extends BaseHandler<OrderStatusEnum> {

	public OrderStatusEnumHandler() {
		super(OrderStatusEnum.class);
	}
}
