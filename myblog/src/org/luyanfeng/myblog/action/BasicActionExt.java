package org.luyanfeng.myblog.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ModelDriven;

//TODO 
@SuppressWarnings("unchecked")
public class BasicActionExt<T> extends BasicAction implements  ServletRequestAware,ServletResponseAware, ModelDriven<T>{

	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private HttpServletRequest request;
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
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}
