package com.chzu.tic.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {
    //管理员操作拦截器
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx=ActionContext.getContext();
		//获取HttpSession中的type属性
		String type=(String)ctx.getSession().get(WebConstant.LOGIN_TYPE);
		if (type!=null&&type.equals(WebConstant.LOGIN_ADMIN)) {
			return invocation.invoke();
		}
		else {
			return Action.LOGIN;
		}
		
	}

}
