package com.ulab.strutss.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class NextInterceptor extends AbstractInterceptor{

	@Override
	// ActionInvocation has list of Interceptors
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Pre NextInterceptor");
		String result=invocation.invoke();
		System.out.println("Post NextInterceptor");
		return result;
	}

}
