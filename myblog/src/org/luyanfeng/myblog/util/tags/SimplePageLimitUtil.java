package org.luyanfeng.myblog.util.tags;

import java.io.IOException;
import java.util.IdentityHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimplePageLimitUtil extends SimpleTagSupport{
	
	private Integer currentNum;
	private Integer totalNum;
	private IdentityHashMap<String,String> parameters;
	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		
		super.doTag();
	}

	
	
}
