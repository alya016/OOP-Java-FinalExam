package course;
import java.util.*;
import enums.*;

public class Schedule {
	private Course course;
	private Vector<LessonType> lessons;
	private Vector<Integer> hours;
	private Vector<Day> days;
	private Vector<Integer> rooms;
	public static Day[] numToDay;
	public static HashMap<Day, Integer> dayToNum; 
	
	{
		dayToNum = new HashMap<Day, Integer>();
		numToDay[1] = Day.MONDAY; dayToNum.put(Day.MONDAY, 1);
		numToDay[2] = Day.TUESDAY; dayToNum.put(Day.TUESDAY, 2);
		numToDay[3] = Day.WEDNESDAY; dayToNum.put(Day.WEDNESDAY, 3);
		numToDay[4] = Day.THURSDAY; dayToNum.put(Day.THURSDAY, 4);
		numToDay[5] = Day.FRIDAY; dayToNum.put(Day.FRIDAY, 5);
		numToDay[6] = Day.SATURDAY; dayToNum.put(Day.SATURDAY, 6);
		numToDay[7] = Day.SUNDAY; dayToNum.put(Day.SUNDAY, 7);
	}
	
	public Schedule(Course course, Vector<Integer> formula, Vector<Integer> hours, Vector<Day> days, Vector<Integer> rooms) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < formula.get(i); j++) {
				if (i == 0) {
					lessons.add(LessonType.LECTURE);
				} else if (i == 1) {
					lessons.add(LessonType.LAB);
				} else {
					lessons.add(LessonType.PRACTICE);
				}
			}
		}
		this.hours = hours;
		this.days = days;
		this.rooms = rooms;
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Vector<LessonType> getLessons() {
		return lessons;
	}

	public void setLessons(Vector<LessonType> lessons) {
		this.lessons = lessons;
	}

	public Vector<Integer> getHours() {
		return hours;
	}

	public void setHours(Vector<Integer> hours) {
		this.hours = hours;
	}

	public Vector<Day> getDays() {
		return days;
	}

	public void setDays(Vector<Day> days) {
		this.days = days;
	}

	public Vector<Integer> getRooms() {
		return rooms;
	}

	public void setRooms(Vector<Integer> rooms) {
		this.rooms = rooms;
	}

	public static Day[] getNumToDay() {
		return numToDay;
	}
	
	public static HashMap<Day, Integer> getDayToNum() {
		return dayToNum;
	}
	
	
	
}
