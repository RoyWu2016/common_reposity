package com.roy.publics.utils;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * Created by ldj on 2017/7/5.
 */
public class ProtoStuffUtil {

	public static <T> byte[] serializer(T o) {
		Schema schema = RuntimeSchema.getSchema(o.getClass());
		return ProtostuffIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
	}

	public static <T> T deserializer(byte[] bytes, Class<T> clazz) throws Exception {
		T obj = null;
		try {
			obj = clazz.newInstance();
			Schema schema = RuntimeSchema.getSchema(obj.getClass());
			ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
		} catch (InstantiationException e) {
			throw new Exception("Fail");
		} catch (IllegalAccessException e) {
			throw new Exception("Another fail");
		}

		return obj;
	}
}
