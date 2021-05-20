package Rubric;

import java.util.HashMap;

public class StudentGrade {
	
	private HashMap<Integer, Integer> studentGrades;
	
	public StudentGrade() {
	}

	public StudentGrade(HashMap<Integer, Integer> studentGrades) {
		this.studentGrades = studentGrades;
	}

	public HashMap<Integer, Integer> getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(HashMap<Integer, Integer> studentGrades) {
		this.studentGrades = studentGrades;
	}

}
