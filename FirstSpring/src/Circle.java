import org.springframework.beans.factory.annotation.Autowired;

public class Circle {
Point point;

public Point getPoint() {
	return point;
}
@Autowired
/*@Autowire connect Circle with Point beans in XML or* 
 * @Autowire gets the Point bean from XML and assigns it to Point object in Circle class*/ 
public void setPoint(Point point) {
	this.point = point;
}
}
