package report;
import database.GlobalDate;

public class News extends Report {
	public News() {}
	
	public News(String text, String title, GlobalDate date) {
		super(text, title, date);
	}

	@Override
	public String toString() {
		return "News [getText()=" + getText() + ", getTitle()=" + getTitle() + ", getTime()=" + getDate() + "]";
	}
	
	
}
