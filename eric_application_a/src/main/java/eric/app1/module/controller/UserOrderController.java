package eric.app1.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eric.app1.framework.dto.Page;
import eric.app1.framework.dto.Res;
import eric.app1.framework.dto.enums.CodeEnum;
import eric.app1.module.entity.UserOrder;
import eric.app1.module.request.UserOrderRequest;
import eric.app1.module.service.UserOrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午4:58:09
 * @Description
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class UserOrderController {

	@Autowired
	private UserOrderService userOrderService;

	@ApiOperation(value = "分页获取用户订单", notes = "分页获取用户订单")
	@ApiImplicitParam(name = "orderParam", value = "订单筛选参数", required = false, dataType = "UserOrderRequest")
	@PostMapping("/listByPage")
	public Res<Page<UserOrder>> listOrders(@RequestBody UserOrderRequest orderParam) throws Exception {
		log.info("enter UserOrderController.listOrders");
		if (orderParam == null) {
			orderParam = new UserOrderRequest();
		}
		orderParam.setUserId(1);
		Page<UserOrder> page = userOrderService.listUserOrders(orderParam);
		return new Res<>(CodeEnum.OK, page);
	}

	@ApiOperation(value = "分页获取用户订单(无需认证)", notes = "分页获取用户订单(无需认证)")
	@PostMapping("/listOrdersWithoutAuth")
	public Res<Page<UserOrder>> listOrdersWithoutAuth(@RequestBody UserOrderRequest orderParam) throws Exception {
		log.info("enter UserOrderController.listOrdersWithoutAuth");
		if (orderParam == null) {
			orderParam = new UserOrderRequest();
		}
		orderParam.setUserId(1);
		Page<UserOrder> page = userOrderService.listUserOrders(orderParam);
		return new Res<>(CodeEnum.OK, page);
	}

	@ApiOperation(value = "分页获取用户订单(需要管理员权限)", notes = "分页获取用户订单(需要管理员权限)")
	@PostMapping("/listOrdersWithAdmin")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public Res<Page<UserOrder>> listOrdersWithAdmin(@RequestBody UserOrderRequest orderParam) throws Exception {
		log.info("enter UserOrderController.listOrdersWithAdmin");
		if (orderParam == null) {
			orderParam = new UserOrderRequest();
		}
		orderParam.setUserId(1);
		Page<UserOrder> page = userOrderService.listUserOrders(orderParam);
		return new Res<>(CodeEnum.OK, page);
	}

}
