package users;

public abstract class Employee extends User {
    private double salary;    
    public Employee() {super();}

	public Employee(int userId, String login, String password, String firstName, String lastName, double salary) {
		super(userId, login, password, firstName, lastName);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", UserId=" + getUserId() + ", FirstName=" + getFirstName()
				+ ", LastName=" + getLastName() + "]";
	}
    
	
}
