package eric.app1.module.request;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午5:16:12
 * @Description
 */
@Getter
@Setter
@ToString
@ApiModel(value = "UserOrderRequest", description = "用户订单分页查询Request")
public class UserOrderRequest {

	@ApiModelProperty("订单ID")
	private int id;

	@ApiModelProperty("用户ID")
	private int userId;

	@ApiModelProperty("订单状态")
	private String orderStatus;

	@ApiModelProperty("订单状态集合（与orderStatus并存时，优先用orderStatusList作为参数查询）")
	private List<String> orderStatusList;

	@ApiModelProperty("当前页码（起始页为1）")
	private int pageNum;

	@ApiModelProperty("每页显示条数")
	private int pageSize;
}
