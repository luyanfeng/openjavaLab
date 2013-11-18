package org.luyanfeng.myblog.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ModelDriven;

//TODO 
@SuppressWarnings("unchecked")
public class BasicActionExt<T> extends BasicAction implements  ModelDriven<T>{

	private static final long serialVersionUID = 1L;

	private  T t = null;
	{
		try {
			Type gsclass = this.getClass().getGenericSuperclass();
			if (gsclass instanceof ParameterizedType) {
				ParameterizedType ptype = (ParameterizedType) gsclass;
				Type type = ptype.getActualTypeArguments()[0];
				t = ((Class<T>)type).newInstance();
			} 
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("系统忙，请稍后再试！");
		}
	}
	
	
	@Override
	public T getModel() {
		return t;
	}
}
