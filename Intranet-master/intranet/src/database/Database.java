package database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Vector;
import course.Course;
import report.News;
import users.User;

public class Database implements Serializable, Cloneable {
	
	private HashSet<User> users;
	private HashSet<Course> courses;
	private HashSet<Course> coursesOnRegistration;
	private HashSet<Course> coursesToRegistration;
	private Vector<News> news;
	private File logFile; // THINK ABOUT LOG FILE
	
	public static final Database INSTANCE = new Database();
	
	{
		users = new HashSet<User>();
		courses = new HashSet<Course>();
		coursesOnRegistration = new HashSet<Course>();
		coursesToRegistration = new HashSet<Course>();
		logFile = new File("log.txt");
	}
	
	private Database() {
		
	}
	
	public static Database getInstance() {
		return INSTANCE;
	}
	
	public boolean addAction(String action) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(logFile));
		bw.write(action);
		return true;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

	public HashSet<Course> getCourses() {
		return courses;
	}

	public void setCourses(HashSet<Course> courses) {
		this.courses = courses;
	}

	public HashSet<Course> getCoursesOnRegistration() {
		return coursesOnRegistration;
	}

	public void setCoursesOnRegistration(HashSet<Course> coursesOnRegistration) {
		this.coursesOnRegistration = coursesOnRegistration;
	}

	public HashSet<Course> getCoursesToRegistration() {
		return coursesToRegistration;
	}

	public void setCoursesToRegistration(HashSet<Course> coursesToRegistration) {
		this.coursesToRegistration = coursesToRegistration;
	}

	public Vector<News> getNews() {
		return news;
	}

	public void setNews(Vector<News> news) {
		this.news = news;
	}

	public boolean isValidUser(String login, String password) {
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
}
