package org.luyanfeng.myblog.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtil {

	private GenericUtil() {
	}
	
	public static <T> Class<T> getGenericClass(Class<T> clazz){
		if(clazz != null){
			Type gs = clazz.getGenericSuperclass();
			if(gs instanceof ParameterizedType){
				ParameterizedType pt = (ParameterizedType)gs;
				Type type = pt.getActualTypeArguments()[0];
				if(type instanceof Class){
					return (Class)type;
				}
			}
		}
		
		return null;
		
	}
}
