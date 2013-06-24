package com.ulab.SpringIoc_2;

public class ServiceProvider {
	Draw draw;
public Draw getBean(String beanType){
	if(beanType=="drawBean"){ 
		draw=new Draw();
		draw.setType(new Triangle());
		return draw;
		}
return null;
}

}
