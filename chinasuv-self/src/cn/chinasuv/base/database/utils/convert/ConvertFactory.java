package cn.chinasuv.base.database.utils.convert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConvertFactory {

	public static Map<String, Convert<?, ?>> convertHandlers = new HashMap<String, Convert<?, ?>>();

	/**
	 * 注册转换器
	 */
	static {

		convertHandlers.put(
				String.class.getName() + "To" + Date.class.getName(),
				new ObjectToDateConvert());

		convertHandlers.put(
				String.class.getName() + "To" + Double.class.getName(),
				new ObjectToFloatConvert());
		convertHandlers.put(
				String.class.getName() + "To" + double.class.getName(),
				new ObjectToFloatConvert());

		convertHandlers.put(
				String.class.getName() + "To" + Float.class.getName(),
				new ObjectToFloatConvert());
		convertHandlers.put(
				String.class.getName() + "To" + float.class.getName(),
				new ObjectToFloatConvert());

		convertHandlers.put(
				String.class.getName() + "To" + Integer.class.getName(),
				new ObjectToIntegerConvert());
		convertHandlers.put(
				String.class.getName() + "To" + int.class.getName(),
				new ObjectToIntegerConvert());
		convertHandlers.put(
				String.class.getName() + "To" + Long.class.getName(),
				new ObjectToLongConvert());
		convertHandlers.put(
				String.class.getName() + "To" + long.class.getName(),
				new ObjectToLongConvert());

		Set<Entry<String, Convert<?, ?>>> entites = convertHandlers.entrySet();
		StringBuilder b = new StringBuilder();
		b.append("{");
		for (Entry<String, Convert<?, ?>> entry : entites) {
			b.append(entry.getKey()).append("=").append(entry.getValue())
					.append(",");
		}
		b.append("}");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T convert(Class<T> clazz, Object val) {
		Object ss = String.class.getName() + "To" + clazz.getName();
		Convert cv = convertHandlers.get(ss);
		if (cv == null) {
			return null;
		}
		return (T) cv.convert(val);
	}
}