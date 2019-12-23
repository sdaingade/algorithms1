package algos.util;

import java.util.Comparator;
import java.util.Arrays;

public class Student {
	private String _name;
	private int _section;
	
	public static final Comparator<Student> BY_NAME = new ByName();
	public static final Comparator<Student> BY_SECTION = new BySection();
	
	public Student(String name, int section) {
		_name = name;
		_section = section;
	}
	
	private static class ByName implements Comparator<Student> {
		public int compare(Student u, Student v) {
			return u._name.compareTo(v._name);
		}
	}
	
	public static class BySection implements Comparator<Student> {
		public int compare(Student u, Student v) {
			return u._section - v._section;
		}
	}
	
	public String toString() {
		return String.format("name: %s, section: %s", _name, _section);
	}
	
	public static void main(String[] args) {
		Student[] students  = {new Student("Ishaan", 5), new Student("Vanessa", 1)};

		Arrays.sort(students, Student.BY_NAME);
		for (Student student: students)
			System.out.println(student);
		
		Arrays.sort(students, Student.BY_SECTION);
		for (Student student: students)
			System.out.println(student);
	}
}


