package users;
import enums.*;

import java.io.IOException;
import java.util.*;
import course.*;
import database.Database;
import database.GlobalDate;
import report.*;

public class Student extends User {
	
    private int studentId;
    private double gpa;
    public Gender gender;
    private String email;
    private String universityEmail;
    private String phoneNum;
    private String nationality;
    private Date birthDate;
    private Faculty faculty;
    private int yearOfStudy;
    private Vector<Course> courses;
    private Vector<Message> messages;
    private Set<Teacher> ratedTeachers;
    private Vector<Course> registeredCourses;
    
    public Student() {super();}
    
    public Student(int userId, String login, String password, String firstName, String lastName, int studentId,
			Gender gender, String email, String universityEmail, String phoneNum, String nationality, Date birthDate,
			Faculty faculty) {
		super(userId, login, password, firstName, lastName);
		this.studentId = studentId;
		this.gender = gender;
		this.email = email;
		this.universityEmail = universityEmail;
		this.phoneNum = phoneNum;
		this.nationality = nationality;
		this.birthDate = birthDate;
		this.faculty = faculty;
	}
    
    public boolean registerCourse(Course course) throws IOException {
    	int totalCredits = 0;
    	for (Course registeredCourse : registeredCourses) {
    		totalCredits += registeredCourse.getCredits();
    	}
    	if (totalCredits + course.getCredits() <= 21) {
    		this.registeredCourses.add(course);
    		String action = "";
    		action += GlobalDate.getInstance().toString() + ": ";
    		action += "Student " + this.getFirstName() + " " + this.getLastName() + "(id: " + this.getUserId() + ") ";
    		action += "registered course " + course.getId() + " " + course.getName();
    		Database.getInstance().addAction(action);
    		return true;
    	} else {
    		String action = "";
    		action += GlobalDate.getInstance().toString() + ": ";
    		action += "Student " + this.getFirstName() + " " + this.getLastName() + "(id: " + this.getUserId() + ") ";
    		action += "unable to registere course " + course.getId() + " " + course.getName() + "because of exceeding limit of credits.";
    		Database.getInstance().addAction(action);
    		return false;
    	}
    }
    
    public boolean unregisterCourse(Course course) throws IOException {
    	if (this.getRegisteredCourses().contains(course)) {
    		this.registeredCourses.remove(course);
    		String action = "";
    		action += GlobalDate.getInstance().toString() + ": ";
    		action += "Student " + this.getFirstName() + " " + this.getLastName() + "(id: " + this.getUserId() + ") ";
    		action += "unregistered course " + course.getId() + " " + course.getName() + ".";
    		Database.getInstance().addAction(action);
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Vector<CourseFile> viewFiles(Course course) {
    	return course.getFiles();
    }
    
    public HashSet<Teacher> getUnratedTeachers() {
    	HashSet<Teacher> unratedTeachers = new HashSet<Teacher>();
    	for (Course course : courses) {
    		for (Group group : course.getGroups()) {
    			if (group.getStudents().contains(this) && !ratedTeachers.contains(group.getTeacher())) {
    				unratedTeachers.add(group.getTeacher());
    			}
    		}
    	}
    	return unratedTeachers;
    }
    
    public boolean rateTeacher(Teacher teacher, double rate) throws IOException {
    	if (getUnratedTeachers().contains(teacher)) {
    		teacher.setTeacherRate(rate);
    		String action = "";
    		action += GlobalDate.getInstance().toString() + ": ";
    		action += "Student " + this.getFirstName() + " " + this.getLastName() + "(id: " + this.getUserId() + ") ";
    		action += "rated teacher " + teacher.getFirstName() + " " + teacher.getLastName() + "with " + rate + "points.";
    		Database.getInstance().addAction(action);
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Mark getMark(Course course) {
    	return course.getMarks().get(this);
    }
    
    public HashMap<Course, Mark> getAttestation() {
    	HashMap<Course, Mark> attestation = new HashMap<Course, Mark>();
    	for (Course course : courses) {
    		if (course.getYear() == GlobalDate.getInstance().getYear() &&
    				course.getSemester().equals(GlobalDate.getInstance().getSemester())) {
    			attestation.put(course, course.getMarks().get(this));
    		}
    	}
    	return attestation;
    }
    
    public HashMap<Course, Mark> getAttestation(int year, Semester semester) {
    	HashMap<Course, Mark> attestation = new HashMap<Course, Mark>();
    	for (Course course : courses) {
    		if (course.getYear() == year && course.getSemester().equals(semester)) {
    			attestation.put(course, course.getMarks().get(this));
    		}
    	}
    	return attestation;
    }
    
    public void getTranscript() {
    	HashMap<Course, Mark> transcript = new HashMap<Course, Mark>();
    }
    
    public double calculateGPA() {
    	
    	class Pair {
    		public int year;
    		public Semester semester;
    		
    		public Pair(int year, Semester semester) {
    			this.year = year;
    			this.semester = semester;
    		}
    	}
    	
    	HashSet<Pair> pairs = new HashSet<Pair>();

    	for (Course course : courses) {
    		Pair pair = new Pair(course.getYear(), course.getSemester());
    		pairs.add(pair);
    	}
    	
    	int totalSemesters = 0;
    	double totalGPA = 0.0;
    	
    	for (Pair pair : pairs) {
    		totalSemesters++;
    		totalGPA += calculateGPA(pair.year, pair.semester);
    	}
    	
    	if (totalSemesters == 0) {
    		return 0;
    	} else {
    		return totalGPA / totalSemesters;
    	}
    }
    
    public double calculateGPA(int year, Semester semester) {
    	double calcGPA = 0.0;
    	int credits = 0;
    	for (Course course : courses) {
    		if (course.getYear() == year && course.getSemester().equals(semester)) {
    			credits += course.getCredits();
    			calcGPA += course.getMarks().get(this).getGPA();
    		}
    	}
    	if (credits == 0) {
    		return 0;
    	} else {
    		return calcGPA / credits;
    	}
    }
    
    public boolean sendRequest(RequestType rt) throws IOException {
    	Request request = new Request(this, rt);
    	OfficeOfRegister.getRequests().add(request);
    	String action = "";
		action += GlobalDate.getInstance().toString() + ": ";
		action += "Student " + this.getFirstName() + " " + this.getLastName() + "(id: " + this.getUserId() + ") ";
		action += "sent request " + rt.name();
		Database.getInstance().addAction(action);
		return true;
    }
    
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUniversityEmail() {
		return universityEmail;
	}
	
	public void setUniversityEmail(String universityEmail) {
		this.universityEmail = universityEmail;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	
	public Vector<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(Vector<Message> messages) {
		this.messages = messages;
	}
	
	public Set<Teacher> getRatedTeachers() {
		return ratedTeachers;
	}
	
	public void setRatedTeachers(Set<Teacher> ratedTeachers) {
		this.ratedTeachers = ratedTeachers;
	}
	
	public Vector<Course> getRegisteredCourses() {
		return registeredCourses;
	}
	
	public void setRegisteredCourses(Vector<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		return true;
	}

	public String toString() {
		return "Student [studentId=" + studentId + ", gpa=" + gpa + ", gender=" + gender + ", email=" + email
				+ ", universityEmail=" + universityEmail + ", phoneNum=" + phoneNum + ", nationality=" + nationality
				+ ", birthDate=" + birthDate + ", faculty=" + faculty + ", yearOfStudy=" + yearOfStudy
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}

}

