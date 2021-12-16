package report;
import database.GlobalDate;
import enums.*;

public class Message extends Report {
    public CheckStatus checkStatus;
    
    {
    	checkStatus = CheckStatus.UNREAD;
    }

    public Message() {}
    
	public Message(String text, String title, GlobalDate date) {
		super(text, title, date);
	}
	
	public String getText() {
		viewMessage();
		return super.getText();
	}
	
	public String toString() {
		return "Message [checkStatus=" + checkStatus + ", Text=" + getText() + ", Title=" + getTitle()
				+ ", Time=" + getDate() + "]";
	}
	
	public void viewMessage() {
		checkStatus = CheckStatus.READ;
	}
}

