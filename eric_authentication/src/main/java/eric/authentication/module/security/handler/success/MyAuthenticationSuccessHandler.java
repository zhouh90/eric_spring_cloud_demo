//package eric.authentication.module.security.handler.success;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import eric.authentication.framework.dto.R;
//import eric.authentication.framework.dto.R.CodeEnum;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author zhou.hao
// * @email zhouhao@ule.com
// * @createTime 2019年8月13日 下午1:34:59
// * @Description
// */
//@Component
//@Slf4j
//public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		log.info("登录成功");
//		R<Authentication> r = new R<>(CodeEnum.OK, authentication);
//		response.setContentType("application/json");
//		response.setStatus(HttpServletResponse.SC_OK);
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.writeValue(response.getOutputStream(), r);
//		} catch (Exception e) {
//			throw new ServletException();
//		}
//	}
//
//}
