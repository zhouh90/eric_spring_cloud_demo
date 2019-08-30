package eric.framework.oauth2;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月12日 下午5:11:05
 * @Description
 */

public class OAuth2Constant {

	/**
	 * header中用来保存token的key值
	 */
	public static final String TOKEN_HEADER_KEY = "Authorization";

	/**
	 * header中token的格式描述
	 */
	public static final String TOKEN_HEADER_DESC = "token值（格式：Bearer xxx.yyyy.zzz）";

	/**
	 * token前缀
	 */
	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String SECRET = "hy67DtchJ9kjdhRy";

	/**
	 * 授权模式--密码模式
	 */
	public static final String GRANT_PASSWORD = "password";

}
