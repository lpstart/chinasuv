package cn.chinasuv.base.database.utils.convert;

public class ObjectToIntegerConvert implements Convert<Object, Integer> {

	public Integer convert(Object source) {
		if (source == null)
			return null;
		try {
			return Integer.parseInt(source.toString().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
