package eric.app1.module.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午9:39:18
 * @Description
 */
@Getter
@Setter
@ToString
public class UserOrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单详情ID
	 */
	private int id;
	/**
	 * 订单ID
	 */
	private int orderId;
	/**
	 * 商品ID
	 */
	private int productId;
	/**
	 * 订单名称
	 */
	private String orderName;
	/**
	 * 订单缩略图
	 */
	private String orderPic;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
