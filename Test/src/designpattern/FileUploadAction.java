package designpattern;

public class FileUploadAction {
	public void print(){
	ServiceProvider provider=ServiceProvider.getServiceProvider();
	System.out.println(provider.getUser().getPassWord());
	}
}
