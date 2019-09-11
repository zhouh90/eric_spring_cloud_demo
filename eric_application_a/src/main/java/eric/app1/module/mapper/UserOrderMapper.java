package eric.app1.module.mapper;

import java.util.List;

import eric.app1.module.entity.UserOrder;
import eric.app1.module.request.UserOrderRequest;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午5:36:56
 * @Description 用户订单mapper
 */

public interface UserOrderMapper {

	/**
	 * 根据参数查询用户订单
	 * 
	 * @param orderParam
	 * @return
	 */
	List<UserOrder> listUserOrders(UserOrderRequest orderParam);

	/**
	 * 根据参数查询用户订单数
	 * 
	 * @param orderParam
	 * @return
	 */
	int count(UserOrderRequest orderParam);

}
