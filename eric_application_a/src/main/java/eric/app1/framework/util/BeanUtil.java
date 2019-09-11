package eric.app1.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtil {

	public static void copy(Object father, Object child) {
		BeanUtils.copyProperties(child, father);
	}

	/**
	 * @param : [object]
	 * @return : java.util.Map<java.lang.String,java.lang.Object>
	 * @Description : 把一个对象参数转成Map参数
	 * @author : tangchao
	 **/
	public static Map<String, Object> objectToMapParams(Object object) {
		Map<String, Object> map = new HashMap<>();
		if (object != null) {
			try {
				Field[] fields = object.getClass().getDeclaredFields();
				for (Field field : fields) {
					if (!Modifier.isStatic(field.getModifiers())) {
						if (field.getType() != List.class) {
							field.setAccessible(true);
							Object value = field.get(object);
							if (value != null) {
								if (field.getType() == Date.class) {
									DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									map.put(field.getName(), df.format(value));
								} else {
									map.put(field.getName(), value);
								}
							}
						}
					}
				}
			} catch (IllegalAccessException e) {
				log.error("获取对象值出现异常：", e);
			}
		}
		return map;
	}
}
