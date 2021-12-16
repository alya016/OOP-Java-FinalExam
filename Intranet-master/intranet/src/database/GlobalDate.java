package database;
import enums.Day;
import enums.Semester;

public class GlobalDate {
	
	private int year;
	private Semester semester;
    private int week;
    private Day day;
	
	public static final GlobalDate INSTANCE = new GlobalDate();
	
	private GlobalDate() {};
	
	public static GlobalDate getInstance() {
		return INSTANCE;
	}
    
    {
    	year = 2019;
    	semester = Semester.AUTUMN;
    	week = 1;
    	day = Day.MONDAY;
    }

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}
	
	public void setDate(int year, Semester semester, int week, Day day) {
		setYear(year);
		setSemester(semester);
		setWeek(week);
		setDay(day);
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + week;
		result = prime * result + year;
		return result;
	}

	public String toString() {
		return "GlobalDate [year=" + year + ", semester=" + semester + ", week=" + week + ", day=" + day + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalDate other = (GlobalDate) obj;
		if (day != other.day)
			return false;
		if (semester != other.semester)
			return false;
		if (week != other.week)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}

