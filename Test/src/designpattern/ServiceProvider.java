package designpattern;

public class ServiceProvider {
	User user;
	static ServiceProvider provider=new ServiceProvider();
	private ServiceProvider(){}
	public void setUser(User user){
		this.user=user;
	}
	public User getUser(){
		return user;
	}
	public static ServiceProvider getServiceProvider(){
		return provider;
	}
	
}
