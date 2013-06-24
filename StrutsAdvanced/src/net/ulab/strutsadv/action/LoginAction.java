package net.ulab.strutsadv.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import net.ulab.strutsadv.model.User;
import net.ulab.strutsadv.service.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware {

	User user;
	Map<String, Object> session;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void validate(){
		System.out.println("in validate");
		if(StringUtils.isEmpty(user.getUserName()))
			addFieldError("userName", "Username can't be empty.");
		if(!(user.getPassWord().matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")))
			addFieldError("passWord", "Password must be a combination of letters and numbers.");
		System.out.println(user.getUserName());
	}

	public String execute() {
		LoginService loginService = new LoginService();
		session = ActionContext.getContext().getSession();
		if (loginService.authenticateUser(user)) {
			session.put("user", user);
			setSession(session);
			return SUCCESS;
		}else if(session.containsKey("user")){
			System.out.println("User already in session:"+session.containsKey("user"));
			return SUCCESS;
		} 
		else
			return LOGIN;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
