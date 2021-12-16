package course;
import java.util.*;
import users.*;

public class Group {
	public Course course;
    public Teacher teacher;
    public Vector<Student> students;
    public Map<Student, Mark> marks;
    public Map<Student, Attendance> attendance;
    public Schedule schedule;
    
    public Group() {}
    
	public Group(Teacher teacher, Schedule schedule, Course course) {
		super();
		this.teacher = teacher;
		this.schedule = schedule;
		this.course = course;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Vector<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Vector<Student> students) {
		students = students;
	}
	
	public Map<Student, Mark> getMarks() {
		return marks;
	}
	
	public void setMarks(Map<Student, Mark> marks) {
		this.marks = marks;
	}
	
	public Map<Student, Attendance> getAttendance() {
		return attendance;
	}
	
	public void setAttendance(Map<Student, Attendance> attendance) {
		this.attendance = attendance;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
	
    
    
}
