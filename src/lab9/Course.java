package lab9;

import java.util.List;

// public class Course implements Comparable<Course> {
public class Course {
	String id;
	String title;
	String type;
	List<Student> students;

	public Course(String id, String title, String type, List<Student> students) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
	}

	public String getType() {
		return type;
	}

	public boolean sameType(String type) {
		return this.type.equals(type);

	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public List<Student> getStudents() {
		return students;
	}

	// public Comparable<Course> courseComparator = new Comparable<Course>() {
	// @Override
	// public int compareTo(Course o) {
	// return compareTo(o);
	// }
	// };

	// @Override
	// public int compareTo(Course o) {
	// return this.getNumberOfStudents() - o.getNumberOfStudents();
	// }

}
