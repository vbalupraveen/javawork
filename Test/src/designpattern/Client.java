package designpattern;

public class Client {
	public static void main(String args[]) {
		User user = new User();
		user.setUserName("balu");
		user.setPassWord("1234");
		LoginAction loginAction = new LoginAction();
		loginAction.setUser(user);
		loginAction.execute();
		new FileUploadAction().print();
	}
}
