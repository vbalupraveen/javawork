package designpattern;

public class LoginAction {
	User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void execute(){
		System.out.println(user.getUserName());
		ServiceProvider provider=ServiceProvider.getServiceProvider();
		provider.setUser(getUser());
	}
}
