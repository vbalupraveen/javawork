import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
public static void main(String[] args) {
	/*--------------------------Getting objects through Application context factory--------------------------*/
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	Circle circle=(Circle) context.getBean("circle");
	//circle.setPoint(new Point()); moved to xml inner bean property
	Point point=circle.getPoint();
	point.setX(10.0);
	point.setY(11.0);
	System.out.println("Circle center co-ordinates:"+point.getX()+"   "+point.getY());

	}
}

