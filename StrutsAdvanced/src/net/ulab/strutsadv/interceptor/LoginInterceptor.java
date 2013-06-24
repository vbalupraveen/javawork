package net.ulab.strutsadv.interceptor;

import java.util.Map;

import net.ulab.strutsadv.action.LoginAction;
import net.ulab.strutsadv.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object action = invocation.getAction();
		User user = (User) session.get("user");

		// sb: if the user is already signed-in, then let the request through.
		if (user != null) {
			System.out.println("found session with name="+user.getUserName());
			return invocation.invoke();
		}

		// sb: if the action doesn't require sign-in, then let it through.
		if (!(action instanceof LoginRequired)) {
			return invocation.invoke();
		}

		// sb: if this request does require login and the current action is
		// not the login action, then redirect the user
		if (!(action instanceof LoginAction)) {
			return "login";
		}

		// sb: they either requested the login page or are submitting their
		// login now, let it through
		return invocation.invoke();
	}
}