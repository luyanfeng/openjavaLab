package org.luyanfeng.myblog.configuration;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class GlobalConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("自定义全局类启动....");
		ServletConfig sc = this.getServletConfig();
		Enumeration<String> names = sc.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = sc.getInitParameter(name);
			this.getServletContext().setAttribute(name, value);
		}
	}

	
}
