package cn.chinasuv.base.database.utils.convert;

public class ObjectToLongConvert implements Convert<Object, Long> {

	public Long convert(Object source) {
		if (source == null)
			return null;
		try {
			return Long.parseLong(source.toString().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
