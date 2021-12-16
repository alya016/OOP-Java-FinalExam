package course;
import java.util.Vector;

import enums.Day;
import users.Student;

public class Attendance {
	
	private Student student;
	private Schedule schedule;
	private boolean[][] attendance;
	private Vector<Pair> pairs;
	
	static class Pair implements Comparable{
		
		public Day day;
		public int hour;
		
		public Pair(Day day, int hour) {
			this.day = day;
			this.hour = hour;
		}

		public int compareTo(Object o) {
			Pair p = (Pair)o;
			if (Schedule.dayToNum.get(day) < Schedule.dayToNum.get(p.day)) {
				return -1;
			} else if (Schedule.dayToNum.get(day) > Schedule.dayToNum.get(p.day)) {
				return 1;
			} else if (hour < p.hour) {
				return -1;
			} else if (hour > p.hour) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public Attendance() {}
	
	public Attendance(Student student, Schedule schedule) {
		this.student = student;
		this.schedule = schedule;
		attendance = new boolean[15][schedule.getCourse().getCredits()];
		for (int i = 0; i < schedule.getCourse().getCredits(); i++) {
			pairs.add(new Pair(schedule.getDays().get(i), schedule.getHours().get(i)));
		}
		pairs.sort(null);
	}
	
	public void setLessonVisit(int week, Day day, int hour, boolean isVisited) {
		for (int i = 0; i < pairs.size(); i++) {
			if (pairs.get(i).day.equals(day) && pairs.get(i).hour == hour) {
				attendance[week][i] = isVisited;
				break;
			}
		}
	}
	
}
