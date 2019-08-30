package eric.authentication.module.security.handler.fail;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午4:32:15
 * @Description
 */

public class OauthExceptionSerializer extends StdSerializer<OauthException> {

	private static final long serialVersionUID = 1L;

	public OauthExceptionSerializer() {
		super(OauthException.class);
	}

	@Override
	public void serialize(OauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		gen.writeStartObject();
		gen.writeStringField("code", String.valueOf(value.getHttpErrorCode()));
		String errorMessage = "Bad credentials".equalsIgnoreCase(value.getMessage()) ? "用户名或密码错误" : value.getMessage();
		gen.writeStringField("message", errorMessage + "(" + request.getServletPath() + ")");
		gen.writeObjectField("data", value.getAdditionalInformation());
		gen.writeEndObject();
	}

}
