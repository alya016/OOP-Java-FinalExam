package users;
import java.io.IOException;
import java.util.*;
import enums.*;
import course.*;
import database.Database;
import database.GlobalDate;

public class Department extends Manager {
	
	public Faculty faculty;
	
	public Department() {super();}
	
	public Department(int userId, String login, String password, String firstName, String lastName, double salary,
			Faculty faculty) {
		super(userId, login, password, firstName, lastName, salary);
		this.faculty = faculty;
	}
	
	public Course createCourse(String id, Faculty faculty, int credits, String description, Vector<Integer> formula, 
			String name, String shortName) throws IOException {
		Course course = new Course();
		course.setId(id);
		course.setFaculty(faculty);
		course.setCredits(credits);
		course.setDescription(description);
		course.setFormula(formula);
		course.setName(name);
		course.setShortname(shortName);
		String action = "";
		action += GlobalDate.getInstance().toString() + ": ";
		action += this.faculty + " department ";
		action += "created course " + course.getId() + " " + course.getName();
		Database.getInstance().addAction(action);
		return course;
	}
	
	public boolean addCourse(Course course) throws IOException {
		HashSet<Course> temp = Database.getInstance().getCoursesToRegistration();
		if (temp.contains(course)) {
			String action = "";
			action += GlobalDate.getInstance().toString() + ": ";
			action += this.faculty + " department ";
			action += "is unable to add course " + course.getId() + " " + course.getName() + " to waiting list because it is already there.";
			Database.getInstance().addAction(action);
			return false;
		} else {
			temp.add(course);
			String action = "";
			action += GlobalDate.getInstance().toString() + ": ";
			action += this.faculty + " department ";
			action += "added course " + course.getId() + " " + course.getName() + " to waiting list.";
			Database.getInstance().addAction(action);
			Database.getInstance().setCoursesToRegistration(temp);
			return true;
		}
	}
	
	public Group createGroup(Course course, Schedule schedule, Teacher teacher) throws IOException {
		Group group = new Group(teacher, schedule, course);
		if (!teacher.getCourses().contains(course)) {
			Vector<Course> courses = teacher.getCourses();
			courses.add(course);
			teacher.setCourses(courses);
		}
		String action = "";
		action += GlobalDate.getInstance().toString() + ": ";
		action += this.faculty + " department";
		action += " created group for " + course.getId() + " " + course.getName() + "course.";
		Database.getInstance().addAction(action);
		return group;
	}
	
	public boolean addGroup(Group group) throws IOException {
		Vector<Group> groups = group.getCourse().getGroups();
		if (groups.contains(group)) {
			String action = "";
			action += GlobalDate.getInstance().toString() + ": ";
			action += this.faculty + " department";
			action += " is unable to add group to the " + group.getCourse().getId() + " " + group.getCourse().getName() 
					+ "course because it is already exist.";
			Database.getInstance().addAction(action);
			return false;
		} else {
			String action = "";
			action += GlobalDate.getInstance().toString() + ": ";
			action += this.faculty + " department";
			action += " added group to the " + group.getCourse().getId() + " " + group.getCourse().getName() + "course.";
			Database.getInstance().addAction(action);
			return true;
		}
	}
 
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String toString() {
		return "Department [faculty=" + faculty + ", Salary=" + getSalary() + ", UserId=" + getUserId()
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}
	
	
}

