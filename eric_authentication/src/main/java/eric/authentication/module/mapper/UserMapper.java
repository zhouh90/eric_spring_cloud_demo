package eric.authentication.module.mapper;

import org.apache.ibatis.annotations.Param;

import eric.authentication.module.entity.User;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午11:10:16
 * @Description 用户Mapper
 */

public interface UserMapper {

	User findUserByLoginName(@Param(value = "loginName") String loginName);

}
