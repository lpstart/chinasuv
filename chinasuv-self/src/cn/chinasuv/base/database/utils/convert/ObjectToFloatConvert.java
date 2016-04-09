package cn.chinasuv.base.database.utils.convert;

public class ObjectToFloatConvert implements Convert<Object, Float> {

	public Float convert(Object source) {
		if (source == null)
			return null;
		try {
			return Float.parseFloat(source.toString().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
