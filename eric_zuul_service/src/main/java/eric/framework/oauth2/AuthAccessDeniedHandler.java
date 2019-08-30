//package eric.app1.framework.oauth2;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import eric.app1.framework.dto.R;
//import eric.app1.framework.dto.R.CodeEnum;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author zhou.hao
// * @email zhouhao@ule.com
// * @createTime 2019年8月14日 上午9:34:10
// * @Description
// */
//@Slf4j
//public class AuthAccessDeniedHandler implements AccessDeniedHandler {
//
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response,
//			AccessDeniedException accessDeniedException) throws IOException, ServletException {
//		log.info("cache an accessDeniedException " + accessDeniedException);
//		R<Object> r = new R<>(CodeEnum.AUTHENTICATION_FAILED, null);
//		response.setContentType("application/json");
//		response.setStatus(HttpServletResponse.SC_OK);
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.writeValue(response.getOutputStream(), r);
//		} catch (Exception e) {
//			throw new ServletException();
//		}
//
//	}
//
//}
