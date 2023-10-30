package lab_extra_arraylist;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	public double getGPA() {
		return GPA;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getId() {
		return id;
	}

	public boolean comparebirthdays(int birthDay) {
		return this.birthYear == birthDay;
	}

	public boolean compareId(String id) {
		return this.id.equals(id);
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthYear=" + birthYear +
				", GPA=" + GPA +
				'}';
	}
}
