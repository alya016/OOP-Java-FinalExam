package users;
import java.util.*;
import report.*;
import course.*;
import database.Database;

public class OfficeOfRegister extends Manager {
	
	private static Vector<Request> requests;
	public OfficeOfRegister() {super();}
	
	public OfficeOfRegister(int userId, String login, String password, String firstName, String lastName, double salary) {
		super(userId, login, password, firstName, lastName, salary);
	}
	
	public boolean addCourseToRegistration(Course course) {
		HashSet<Course> coursesToRegistration = Database.getInstance().getCoursesToRegistration();
		coursesToRegistration.remove(course);
		Database.getInstance().setCoursesToRegistration(coursesToRegistration);
		HashSet<Course> coursesOnRegistration = Database.getInstance().getCoursesOnRegistration();
		if (coursesOnRegistration.contains(course)) {
			return false;
		} else {
			coursesOnRegistration.add(course);
			Database.getInstance().setCoursesOnRegistration(coursesOnRegistration);
			return true;
		}
	}
	
	public void approveRegistration() {
		
	}
	
	public static Vector<Request> getRequests() {
		return requests;
	}
	public void setRequests(Vector<Request> requests) {
		OfficeOfRegister.requests = requests;
	}
	
	
}

