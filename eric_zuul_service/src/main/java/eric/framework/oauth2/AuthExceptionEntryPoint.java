package eric.framework.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import eric.framework.dto.R;
import eric.framework.dto.R.CodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午10:47:31
 * @Description 自定义无效token时的返回格式
 */
@Slf4j
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("cache an authException " + authException);
		R<Object> r = new R<>(CodeEnum.AUTHENTICATION_FAILED, null);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getOutputStream(), r);
		} catch (Exception e) {
			throw new ServletException();
		}
	}

}
