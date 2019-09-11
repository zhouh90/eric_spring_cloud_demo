package eric.app1.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import eric.app1.framework.dto.Res;
import eric.app1.framework.dto.enums.CodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 上午10:45:24
 * @Description 全局异常处理类
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public Res<Object> convertException(HttpServletRequest request, Exception e) throws Exception {
		log.error("enter GlobalExceptionHandler.convertException: 捕获的异常=====================================");
		log.error(e.getMessage(), e);
		return new Res<Object>(CodeEnum.ERROR, null, e.getMessage() + "(" + request.getRequestURI() + ")");
	}

}
