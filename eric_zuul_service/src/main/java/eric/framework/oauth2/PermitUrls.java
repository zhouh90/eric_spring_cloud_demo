package eric.framework.oauth2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月13日 上午10:26:29
 * @Description 可匿名访问url集合
 */

public class PermitUrls {

	public static String[] swaggerUrls;
	public static String[] permitUrls;

	static {
		// Swagger相关的api
		List<String> swaggerUrlList = new ArrayList<String>();
//		swaggerUrlList.add("/swagger-ui.html");
//		swaggerUrlList.add("/swagger-ui.html*");
//		swaggerUrlList.add("/swagger-resources/**");
//		swaggerUrlList.add("/webjars/springfox-swagger-ui/**");
//		swaggerUrlList.add("/v2/api-docs/**");
		swaggerUrls = swaggerUrlList.toArray(new String[swaggerUrlList.size()]);

		// 允许匿名访问的api
		List<String> permitUrlList = new ArrayList<String>();
		permitUrlList.add("/api-1/test");
		permitUrlList.add("/api-1/order/listOrdersWithoutAuth");
		permitUrlList.add("/actuator/**");
		permitUrls = permitUrlList.toArray(new String[permitUrlList.size()]);
	}

}
