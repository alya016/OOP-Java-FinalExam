package users;
import report.*;
import database.Database;
import java.util.*;

public abstract class Manager extends Employee {
	
	public Manager() {super();}
	
    public Manager(int userId, String login, String password, String firstName, String lastName, double salary) {
		super(userId, login, password, firstName, lastName, salary);
		// TODO Auto-generated constructor stub
	}
    
	public boolean postNews(News news) {
		Vector<News> newss = Database.getInstance().getNews();
		newss.add(news);
		Database.getInstance().setNews(newss);
		return true;
    }
	
    public String viewInfo(int id) {
    	for (User u: Database.getInstance().getUsers())
    		if ((u instanceof Student) || (u instanceof Teacher))
    			return u.toString();
    	return "User Not Found";
    }
    public void SendMessage(Message message, Teacher teacher) {
    	Vector <Message> m = teacher.getMessages();
    	m.add(message);
    	teacher.setMessages(m);
    }
    public void SendMessage(Message message, Student student) {
    	Vector <Message> m = student.getMessages();
    	m.add(message);
    	student.setMessages(m);
    }
    public void sendOrder(Order order, TechSupport techSupport) {
    	TechSupport.orders.add(order);
    }
    //end
    
    
}

