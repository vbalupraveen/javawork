package com.ulab.book;

public class ServiceProviderFrameWork {
	BookReader reader;
public ServiceProviderFrameWork() {
	reader = new BookReader(new JavaBookLibrary());
}
public BookReader getServiceProviderFrameWork(){
	return reader;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
