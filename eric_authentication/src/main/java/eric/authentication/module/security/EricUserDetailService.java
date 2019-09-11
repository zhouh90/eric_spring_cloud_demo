package eric.authentication.module.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import eric.authentication.module.entity.User;
import eric.authentication.module.entity.enums.AuthoritiesEnum;
import eric.authentication.module.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午1:20:33
 * @Description
 */
@Slf4j
public class EricUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
//	@Autowired
//	private HttpServletRequest request; //可以从request中获取clientId信息

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("enter BaseUserDetailService.loadUserByUsername:{}", username);
		User user = userService.findUserByLoginName(username);
		if (user != null) {
			UserAuthentication ua = new UserAuthentication();
			ua.setAccountNonExpired(true);
			ua.setAccountNonLocked(true);
			ua.setCredentialsNonExpired(true);
			ua.setEnabled(true);
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			if ("test1".equalsIgnoreCase(user.getLoginName())) {
				authorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(AuthoritiesEnum.USER.getRole()));
			} else if ("test2".equalsIgnoreCase(user.getLoginName())) {
				authorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(AuthoritiesEnum.ADMIN.getRole()));
			}
			ua.setAuthorities(authorities);
			ua.setId(user.getId());
			ua.setUsername(user.getLoginName());
			ua.setPassword(user.getPassword());
			ua.setNickName(user.getNickName());
			return ua;
		}
		log.info("用户【{}】尚未注册", username);
		return null;
	}

}
