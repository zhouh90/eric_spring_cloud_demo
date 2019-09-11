package eric.app1.module.entity;

import java.util.Date;

import lombok.Data;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:21:59
 * @Description 用户实体
 */

@Data
public class User {

	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 登录账户
	 */
	private String loginName;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
