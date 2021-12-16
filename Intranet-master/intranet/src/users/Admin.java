package users;
import java.util.HashSet;
import java.util.Vector;
import database.Database;

public class Admin extends User {
	
	public Admin() {super();}
	
	public Admin(int userId, String login, String password, String firstName, String lastName) {
		super(userId, login, password, firstName, lastName);
	}
	
	public User createUser(String type, int id, String firstName, String lastName) {
		User user = UserFactory.getUser(type);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserId(id);
		return user;
	}
	
	public boolean addUser(User user) {
		HashSet<User> temp = Database.getInstance().getUsers();
		if (temp.contains(user)) {
			return false;
		} else {
			temp.add(user);	
			Database.getInstance().setUsers(temp);
			return true;
		}
	}
	
	public boolean removeUser(User user) {
		HashSet<User> temp = Database.getInstance().getUsers();
		if (temp.contains(user)) {
			temp.remove(user);
			Database.getInstance().setUsers(temp);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateUser(int userId) {
		
	}
	
	public String getUserInfo(int userId) {
		for (User u: Database.getInstance().getUsers())
			if (u.getUserId() == userId)
				return u.toString();
		return null;
	}
	
	public void seeLogFiles() {
		
	}

	public String toString() {
		return "Admin [UserId=" + getUserId() + ", FirstName=" + getFirstName()
				+ ", LastName=" + getLastName() + "]";
	}
	
	
}

