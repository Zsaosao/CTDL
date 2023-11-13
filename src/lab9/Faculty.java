package lab9;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	String name;
	String address;
	List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxPracticalCourse = null;
		int maxPracticalCourseStudents = 0;
		for (Course course : courses) {
			if (course.sameType("Practical") && course.getNumberOfStudents() > maxPracticalCourseStudents) {
				maxPracticalCourse = course;
				maxPracticalCourseStudents = course.getNumberOfStudents();
			}
		}
		return maxPracticalCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> studentsByYear = new HashMap<Integer, List<Student>>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				if (!studentsByYear.containsKey(student.getYear())) {
					ArrayList<Student> students = new ArrayList<Student>();
					students.add(student);
					studentsByYear.put(student.getYear(), students);
				} else {
					studentsByYear.get(student.getYear()).add(student);
				}
			}
		}
		return studentsByYear;
	}

	// returns the course according to the given type (type). Courses are arranged
	// in descending order by number number of students registered.
	public Set<Course> filterCourses(String type) {
		Set<Course> filteredCourses = new TreeSet<Course>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getNumberOfStudents() - o2.getNumberOfStudents();
			}
		});
		for (Course course : courses) {
			if (course.sameType(type)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1", "John", 1));
		students.add(new Student("2", "Mary", 1));

		List<Student> students2 = new ArrayList<Student>();
		students2.add(new Student("5", "Tom", 2));
		students2.add(new Student("6", "Lucy", 2));
		students2.add(new Student("7", "David", 2));

		List<Student> students3 = new ArrayList<Student>();
		students3.add(new Student("3", "Peter", 3));
		students3.add(new Student("4", "Jane", 3));
		students3.add(new Student("9", "Bob", 3));
		students3.add(new Student("10", "Eve", 3));

		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("3", "Python", "Practical", students3));
		courses.add(new Course("1", "Java", "Practical", students));
		courses.add(new Course("2", "C++", "Theory", students2));

		// sort courses by number of students by coparable
		// Collections.sort(courses);

		Faculty faculty = new Faculty("FIT", "RMIT", courses);

		System.out.println("Max practical course: " +
				faculty.getMaxPracticalCourse().title);

		Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();
		for (Integer year : studentsByYear.keySet()) {
			System.out.println("Year " + year + ":");
			for (Student student : studentsByYear.get(year)) {
				System.out.print(student.name + " ");
			}
			System.out.println();
		}

		Set<Course> filteredCourses = faculty.filterCourses("Practical");
		for (Course course : filteredCourses) {
			System.out.println("Title " + course.title + ": " + course.getNumberOfStudents());
		}

	}

}
