package com.ulab.SpringIOC_Coll_Inj;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleBean {
	public static void main(String args[]){
ApplicationContext context=new ClassPathXmlApplicationContext("Coll_Inj_ApplicationContext.xml");
DemoBean demoBean =(DemoBean) context.getBean("demoBean");
DemoBean childDemo =(DemoBean) context.getBean("childDemo");
List alist=demoBean.getList();
List list=childDemo.getList();
System.out.println(alist.size()+"--"+list.size());
	}
}
