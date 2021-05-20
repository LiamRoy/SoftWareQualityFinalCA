package Rubric;

import java.util.ArrayList;
import java.util.HashMap;
public class Controller {
	
	public Rubric createEmptyRubric() {
		Rubric rubric = new Rubric();
		return rubric;
	}
	
	public Rubric createRubric(String name, ArrayList<Criterion> criterion) {
		
		ArrayList<Criterion> criterions = criterion;
		Rubric rubric = new Rubric(name, criterions);
		return rubric;
	}
	
	public void addCriteria(Rubric rubric, Criterion criterion) {
		rubric.addCriterion(criterion);
	}
	
	public Rubric searchCriteria(ArrayList<Rubric>rubric, String name) {
		Rubric rubrics = new Rubric();
		
		for(Rubric r : rubric) {
			if(r.getName().equals(name)) {
				rubrics = r;
			}
		}
		return rubrics;
	}
	
	public ArrayList<Rubric> allRubrics(ArrayList<Rubric> rubrics){
		return rubrics;
	}
	
	public StudentGrade createGrade(int grade1, int grade2, int grade3, int grade4) {
		StudentGrade studentGrade = new StudentGrade();
		
		HashMap<Integer, Integer> grades = new HashMap<>();
		
		grades.put(1, grade1);
		grades.put(2, grade2);
		grades.put(3, grade3);
		grades.put(4, grade4);
		
		studentGrade.setStudentGrades(grades);
		return studentGrade;
	}
	
	public Rubric addGradetoRubric(Rubric rubric, StudentGrade grade) {
		rubric.addStudentGrade(grade);
		return rubric;
	}
	
	public ArrayList<StudentGrade> getAddGradesFromRubric(ArrayList<Rubric> rubrics, String rubricTitle) {
		ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		
		for(Rubric r: rubrics) {
			if(r.getName().equals(rubricTitle)) {
				studentGrades = r.getGrades();
			}
		}
		return studentGrades;
	}
	
	public static double getGradeAverage(Rubric rubric, int grade) {
		double average = 0;
		
		average = rubric.getAverageGrade();
		return average;
		
	}
	
	public static double getGradeStdDev(Rubric rubric, int grade) {
		double stdDev= 0;
		
		stdDev = rubric.getStdDev();
		return stdDev;
	}
	
	public static Integer getMaxGrade(Rubric rubric, int grade) {
		int max = 0;
		max = rubric.getMaxGrade();
		return max;
	}
	
	public static Integer getMinGrade(Rubric rubric, int grade) {
		int min = 0;
		min = rubric.getMinGrade();
		return min;
	}
	
}
