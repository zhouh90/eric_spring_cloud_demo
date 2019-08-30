package eric.authentication.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eric.authentication.module.entity.User;
import eric.authentication.module.mapper.UserMapper;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:35:22
 * @Description 用户service
 */

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User findUserByLoginName(String loginName) {
		return userMapper.findUserByLoginName(loginName);
	}

}
