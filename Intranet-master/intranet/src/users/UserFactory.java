package users;

public class UserFactory {
	
	public static User getUser(String userType) {
		if (userType == null) return null;
		if (userType.equalsIgnoreCase("Student"))
			return new Student();
		else
		if (userType.equalsIgnoreCase("Teacher"))
			return new Teacher();
		else
		if (userType.equalsIgnoreCase("Office of register"))
			return new OfficeOfRegister();
		if (userType.equalsIgnoreCase("Department"))
			return new Department();
		return null;
	}

}
