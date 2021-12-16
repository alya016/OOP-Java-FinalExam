package report;
import java.util.Vector;

import database.GlobalDate;
import enums.*;
import users.Student;

public class Request {
	private Student student;
    private RequestType requestType;
    private CheckStatus checkStatus;
    private ConfirmationStatus confirmationStatus;
    
    {
    	checkStatus = CheckStatus.UNREAD;
    	confirmationStatus = null;
    }
    
    public Request() {}
    
	public Request(Student student, RequestType requestType) {
		super();
		this.student = student;
		this.requestType = requestType;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public RequestType getRequestType() {
		return requestType;
	}
	
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}
	
	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	public ConfirmationStatus getConfirmationStatus() {
		return confirmationStatus;
	}
	
	public void setConfirmationStatus(ConfirmationStatus confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}
    
	public void viewRequest() {
		checkStatus = CheckStatus.READ;
	}
	
	public String toString() {
		return "Dear, " + student.getFirstName() + ", your document " + requestType.name().toLowerCase() + "is ready. "
				+ "You can take it in the Office of Register.";
	}
    
	public void acceptRequest() {
		confirmationStatus = ConfirmationStatus.ACCEPT;
		Vector<Message> temp = student.getMessages();
		String title = "Take document";
		temp.add(new Message(this.toString(), title, GlobalDate.getInstance()));
		student.setMessages(temp);
	}
	
	public void rejectRequest() {
		confirmationStatus = ConfirmationStatus.REJECT;
	}
}

