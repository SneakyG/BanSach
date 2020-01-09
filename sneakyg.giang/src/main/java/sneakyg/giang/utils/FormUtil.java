package sneakyg.giang.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest req) {
		T object = null;
		try {
			object = tClass.getDeclaredConstructor().newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return object;
	}
}
