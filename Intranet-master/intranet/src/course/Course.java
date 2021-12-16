package course;
import enums.*;
import users.*;
import java.util.*;

public class Course {
	public String id;
	public Faculty faculty;
	public int credits;
	private int year;
	private Semester Semester;
	private Map<Student, Mark> marks;
	public String name;
	public String shortname;
	private Vector<CourseFile> files;
	public String description;
	private Vector<Integer> formula;
	private Vector<Course> prerequesites;
	private Vector<Group> groups;
	
	public Course() {}
	
	public Course(String id, Faculty faculty, int credits, int year, enums.Semester semester, String name,
			String shortName, Vector<Integer> formula) {
		super();
		this.id = id;
		this.faculty = faculty;
		this.credits = credits;
		this.year = year;
		Semester = semester;
		this.name = name;
		this.shortname = shortName;
		this.formula = formula;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public Semester getSemester() {
		return Semester;
	}
	
	public void setSemester(Semester semester) {
		Semester = semester;
	}
	
	public Map<Student, Mark> getMarks() {
		return marks;
	}
	
	public void setMarks(Map<Student, Mark> marks) {
		this.marks = marks;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Vector<CourseFile> getFiles() {
		return files;
	}
	
	public void setFiles(Vector<CourseFile> files) {
		this.files = files;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Vector<Integer> getFormula() {
		return formula;
	}
	
	public void setFormula(Vector<Integer> formula) {
		this.formula = formula;
	}
	
	public Vector<Course> getPrerequesites() {
		return prerequesites;
	}
	
	public void setPrerequesites(Vector<Course> prerequesites) {
		this.prerequesites = prerequesites;
	}
	
	public Vector<Group> getGroups() {
		return groups;
	}
	
	public void setGroups(Vector<Group> groups) {
		this.groups = groups;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (faculty != other.faculty)
			return false;
		if (formula == null) {
			if (other.formula != null)
				return false;
		} else if (!formula.equals(other.formula))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String toString() {
		return "Course [id=" + id + ", faculty=" + faculty + ", credits=" + credits + ", year=" + year + ", Semester="
				+ Semester + ", marks=" + marks + ", name=" + name + ", files=" + files
				+ ", description=" + description + ", formula=" + formula + ", prerequesites=" + prerequesites
				+ ", groups=" + groups + "]";
	}
	
	
}

