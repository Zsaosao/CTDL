package lab_extra_arraylist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Clazz {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private ArrayList<Student> students = new ArrayList<Student>();

	public Clazz(String name, String year) {
		this.name = name;
		this.year = year;
	}

	public void loadStudents(String fileName) throws IOException {
		this.students = StudentUtils.loadStudents(fileName);
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < students.size() - 1; j++) {
				if (c.compare(students.get(j), students.get(j + 1)) > 0) {
					Student temp = students.get(j);
					students.set(j, students.get(j + 1));
					students.set(j + 1, temp);
				}
			}
		}
	}

	// get top n students with highest GPA
	@SuppressWarnings("unchecked")
	public ArrayList<Student> getTopNStudents(int n) {
		if (n > this.students.size()) {
			return null;
		}
		ArrayList<Student> result = new ArrayList<Student>();
		Comparator<Student> gpaComparator = (a, b) -> Double.compare(b.getGPA(), a.getGPA());
		ArrayList<Student> temp = ((ArrayList<Student>) this.students.clone());
		temp.sort(gpaComparator);

		for (int i = 0; i < n; i++) {
			result.add(temp.get(i));
		}

		return result;
	}

	// get random n students from the list of students
	@SuppressWarnings("unchecked")
	public ArrayList<Student> getRandomNStudents(int n) {
		if (n > this.students.size()) {
			return null;
		}
		ArrayList<Student> result = new ArrayList<Student>();
		ArrayList<Student> temp = ((ArrayList<Student>) this.students.clone());
		for (int i = 0; i < n; i++) {
			int random = (int) (Math.random() * temp.size());
			result.add(temp.get(random));
			temp.remove(random);
		}
		return result;
	}

	// remove a student with a given id
	public boolean removeStudent(String id) {
		for (Student student : students) {
			if (student.compareId(id)) {
				students.remove(student);
				return true;
			}
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			if (student.comparebirthdays(birthYear)) {
				result.add(student);
			}
		}
		return result;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		System.out.println("Class " + name + " - " + year);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("=====================================");
	}

}
