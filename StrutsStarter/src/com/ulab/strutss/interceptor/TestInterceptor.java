package com.ulab.strutss.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TestInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	// ActionInvocation has list of Interceptors
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Pre TestInterceptor");
		String result=invocation.invoke();
		System.out.println("Post TestInterceptor");
		return result;
	}

}
