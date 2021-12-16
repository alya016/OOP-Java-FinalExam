package report;
import database.GlobalDate;
import enums.*;

public class Order extends Report {
    private CheckStatus checkStatus;
    private ConfirmationStatus confirmationStatus;
    
    {
    	checkStatus = CheckStatus.UNREAD;
    	confirmationStatus = null;
    }
    
    public Order() {}
	public Order(String text, String title, GlobalDate date) {
		super(text, title, date);
	}
	
	public String getText() {
		viewOrder();
		return super.getText();
	}
	
	public String toString() {
		return "Order [checkStatus=" + checkStatus + ", confirmationStatus=" + confirmationStatus + ", Text="
				+ getText() + ", Title=" + getTitle() + ", Time=" + getDate() + "]";
	}
    
	public void viewOrder() {
		checkStatus = CheckStatus.READ;
	}
	
	public void acceptOrder() {
		confirmationStatus = ConfirmationStatus.ACCEPT;
	} 
	
	public void rejectOrder() {
		confirmationStatus = ConfirmationStatus.REJECT;
	}
}

