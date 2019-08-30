package eric.app1.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eric.app1.framework.constant.Constants;
import eric.app1.framework.dto.Page;
import eric.app1.module.entity.UserOrder;
import eric.app1.module.mapper.UserOrderMapper;
import eric.app1.module.request.UserOrderRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午5:22:29
 * @Description 用户订单service
 */

@Service
@Slf4j
public class UserOrderService {

	@Autowired
	private UserOrderMapper userOrderMapper;

	public Page<UserOrder> listUserOrders(UserOrderRequest orderParam) throws Exception {
		log.info("enter UserOrderService.listUserOrders...");
		if (orderParam == null || orderParam.getUserId() <= 0) {
			throw new Exception("查询用户订单参数错误");
		}
		int total = userOrderMapper.count(orderParam);
		List<UserOrder> resultList = userOrderMapper.listUserOrders(orderParam);
		int currentPage = orderParam.getPageNum() == 0 ? 1 : orderParam.getPageNum();
		int pageSize = orderParam.getPageSize() == 0 ? Constants.DEFAULT_PAGE_SIZE : orderParam.getPageSize();
		Page<UserOrder> page = new Page<>(currentPage, total);
		page.setPageSize(pageSize);
		page.setResultRows(resultList);
		return page;

	}

}
