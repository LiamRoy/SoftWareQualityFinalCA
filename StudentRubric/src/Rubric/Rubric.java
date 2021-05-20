package Rubric;

import java.util.ArrayList;

public class Rubric {

	private String name;
	private ArrayList<Criterion> criterions = new ArrayList<Criterion>();
	private ArrayList<StudentGrade> grades = new ArrayList<>();
	public Rubric() {
	}
	public Rubric(String name) {
		this.name=name;
	}
	
	public Rubric(String name, ArrayList<Criterion> criterions) {
		this.name=name;
		this.criterions=criterions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Criterion> getCriterions() {
		return this.criterions;
	}

	public void setCriterions(ArrayList<Criterion> criterions) {
		this.criterions = criterions;
	}
	
	public void addCriterion(Criterion criterion) {
		this.criterions.add(criterion);
	}
	
	public ArrayList<StudentGrade> addStudentGrade(StudentGrade grade){
		ArrayList<StudentGrade> grades = new ArrayList();
		
		if(this.grades == null) {
			grades.add(grade);
		}
		else {
			this.grades.add(grade);
		}
		return this.grades;
	}

	public ArrayList<StudentGrade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<StudentGrade> grades) {
		this.grades = grades;
	}
	
	//CALCULATIONS
	
	public double getAverageGrade() {
		int total=0;
		int totalGrades=0;
		double average = 0;
		
		for(StudentGrade sGrade: this.grades) {
			
			for(int singleGrade: sGrade.getStudentGrades().values()) {
				total++;
				totalGrades += singleGrade;
			}
		}
		average = (double) totalGrades / (double) total;
		return average;
	}
	
	public double getStdDev() {
		double stdDev = 0.0;
		double mean = getAverageGrade();
		int total = 0;
		
		for(StudentGrade sGrade: this.grades) {
			for(int singleGrade: sGrade.getStudentGrades().values()) {
				total++;
				stdDev += Math.pow(singleGrade - mean,2);
			}
		}
		return Math.sqrt(stdDev/total);
	}
	
	public Integer getMaxGrade() {
		int highest = grades.get(0).getStudentGrades().get(1);
		
		for(StudentGrade sGrade : this.grades) {
			for(int singleGrade: sGrade.getStudentGrades().values()) {
				if(singleGrade>highest) {
					highest = singleGrade;
				}
			}
		}
		return highest;
	}
	
	public Integer getMinGrade() {
		int lowest = grades.get(0).getStudentGrades().get(1);
		
		for(StudentGrade sGrade : this.grades) {
			for(int singleGrade: sGrade.getStudentGrades().values()) {
				if(singleGrade<lowest) {
					lowest = singleGrade;
				}
			}
		}
		return lowest;
	}
}
