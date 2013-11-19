package org.luyanfeng.myblog.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.LoginAction;
import org.luyanfeng.myblog.util.GenericUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticateInterceptor extends AbstractInterceptor  {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Object action = ai.getAction();
		if(action instanceof LoginAction){// 登录功能例外
			System.out.println("login....");
		}else if(action instanceof ActionSupport){
			System.out.println("限权对像："+action.getClass().getName());
			String userEmail = (String) ai.getInvocationContext().getSession().get(GenericUtil.SessionInfo.USER_EMAIL.toString());
			if(StringUtils.isNotBlank(userEmail)){
				System.out.println("你已登录！！");
				return ai.invoke();
			}else{
				((ActionSupport)ai.getAction()).addActionError("你没有相应的权限");
				return "error";
			}
		}
		return ai.invoke();
	}


}
