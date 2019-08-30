//package eric.app1.framework.filter;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//
///**
// * @author zhou.hao
// * @email zhouhao@ule.com
// * @createTime 2019年8月21日 下午5:40:04
// * @Description
// */
//
//@Component("rbacauthorityservice")
//public class RbacAuthorityService {
//
//	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
//		System.out.println("authentication：" + authentication);
//		Object userInfo = authentication.getPrincipal();
//		boolean hasPermission = false;
//		if (userInfo instanceof UserDetails) {
//			String username = ((UserDetails) userInfo).getUsername();
//			System.out.println("username:" + username);
//			Set<String> allowedUrls = new HashSet<String>();
//			if ("test1".equalsIgnoreCase(username)) {
//				allowedUrls.add("/order/listOrdersWithoutAuth");
//			} else if ("test2".equalsIgnoreCase(username)) {
//				allowedUrls.add("/order/listOrdersWithoutAuth");
//				allowedUrls.add("/order/listOrdersWithAdmin");
//			}
//
//			AntPathMatcher antPathMatcher = new AntPathMatcher();
//			for (String url : allowedUrls) {
//				if (antPathMatcher.match(url, request.getRequestURI())) {
//					hasPermission = true;
//					break;
//				}
//			}
//			return hasPermission;
//		} else {
//			return false;
//		}
//	}
//}
