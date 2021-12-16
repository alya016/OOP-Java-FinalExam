package users;
import java.util.*;
import report.*;

public class TechSupport extends Employee {
    public static Vector<Order> orders;
    
    public TechSupport() {}
	public TechSupport(int userId, String login, String password, String firstName, String lastName, double salary) {
		super(userId, login, password, firstName, lastName, salary);
	}

	public Vector<Order> getOrders() {
		return orders;
	}

	public void setOrders(Vector<Order> orders) {
		TechSupport.orders = orders;
	}

	@Override
	public String toString() {
		return "TechSupport [orders=" + orders + ", Salary=" + getSalary() + ", UserId=" + getUserId()
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}
    
    
}