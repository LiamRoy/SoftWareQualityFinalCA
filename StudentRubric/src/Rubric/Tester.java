package Rubric;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Tester {
	
	Controller controller = new Controller();
	
	//Create Empty Rubric
	@Test
	public void TestEmptyRubricCreation() {
		Rubric rubric = controller.createEmptyRubric();
		assertTrue("Rubric is Created", rubric instanceof Rubric);
	}
	
	//ERROR IN THIS TEST
//	@Test
//	public void TestRubricWithCriterion() {
//		//String name = "Liam";
//		Criterion criterion1 = new Criterion("Design");
//		
//		Rubric rubric = new Rubric();
//		
//		ArrayList<Criterion> criterions = new ArrayList<Criterion>();
//		criterions.add(criterion1);
//		
//		rubric = controller.createRubric("Liam",criterions);
//		
//		assertTrue("Should create a rubric with a critea object",
//				rubric.getCriterions().equals("Design"));
//	}
	
	//Add Criteria
	@Test
	public void TestAddCriterion() {
		
		Rubric r = controller.createEmptyRubric();
		Criterion criteria1 = new Criterion("Design");
		
		controller.addCriteria(r, criteria1);
		
		assertTrue("Criteria should be added",r.getCriterions().get(0).getCriterion().equals("Design"));
	}
	
	//Search in Rubric
	@Test
	public void TestSearchForRubric() {
		Rubric r1 = new Rubric("Test 1");
		Rubric r2 = new Rubric("Test 2");
		Rubric r3 = new Rubric("Test 3");
		
		ArrayList<Rubric> rubrics = new ArrayList<Rubric>();
		rubrics.add(r1);
		rubrics.add(r2);
		rubrics.add(r3);
		
		Rubric search = controller.searchCriteria(rubrics, "Test 2");
		assertTrue("Should return one Rubric", search.getName().equals("Test 2"));
	}
	
	//Show All Criteria
	@Test
	public void TestShowAllCriteria() {
		Rubric r1 = new Rubric("Test 1");
		Rubric r2 = new Rubric("Test 2");
		Rubric r3 = new Rubric("Test 3");
		
		ArrayList<Rubric> rubrics = new ArrayList<Rubric>();
		rubrics.add(r1);
		rubrics.add(r2);
		rubrics.add(r3);
		
		ArrayList<Rubric> allRubrics = new ArrayList<Rubric>();
		allRubrics = controller.allRubrics(allRubrics);
		
		assertTrue("Should return all Rubrics", allRubrics.size()<=3);
	}
	
	//Create Grades
	@Test
	public void TestCreateGrades() {
		int grade1 = 1;
		int grade2 = 2;
		int grade3 = 3;
		int grade4 = 4;
		StudentGrade grade = controller.createGrade(grade1, grade2, grade3, grade4);
		
		assertTrue("Grades should appear", grade.getStudentGrades().size() == 4);
	}
	
	//Add grades to Rubrics
	@Test
	public void TestAddGradestoRubric() {
		ArrayList<Rubric> rubrics = new ArrayList<Rubric>();
		
		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test Title", criterionList);
		
		rubrics.add(r);
		
		int g1 = 1;
		int g2 = 2;
		int g3 = 3;
		int g4 = 4;
		StudentGrade studentGrade = controller.createGrade(g1, g2, g3, g4);
	}
	
	//Show All Grades
	@Test
	public void TestGetAllGrades() {
		ArrayList<Rubric> rubrics = new ArrayList<Rubric>();
		
		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test", criterionList);
		rubrics.add(r);
		
		int g1 = 1;
		int g2 = 2;
		int g3 = 3;
		int g4 = 4;
		
		StudentGrade studentGrade = controller.createGrade(g1, g2, g3, g4);
		r.addStudentGrade(studentGrade);
		
		Rubric specificRubric = controller.searchCriteria(rubrics, "Test");
		assertTrue("Grades should be Added to rubrics",
				specificRubric.getGrades().get(0).getStudentGrades().size() == 4);
	}
	
	//Show Average Grade
	@Test
	public void TestAverageGrade() {
		
		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test", criterionList);
		
		StudentGrade studentGrade = controller.createGrade(4, 2, 2, 4); // 12
		StudentGrade studentGrade1 = controller.createGrade(2, 4, 4, 2);// 12
		
		controller.addGradetoRubric(r, studentGrade);
		controller.addGradetoRubric(r, studentGrade1);
		
		double average = Controller.getGradeAverage(r, 2);
		
		// 4+2+2+4 = 12/3 = 3
		assertEquals(average, 3);
		
	}
	
	//Show Standard Deviation
	@Test
	public void TestStdDevGrade() {

		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test", criterionList);
		
		StudentGrade studentGrade = controller.createGrade(4, 2, 2, 4); // 12
		StudentGrade studentGrade1 = controller.createGrade(2, 4, 4, 2);// 12
		
		controller.addGradetoRubric(r, studentGrade);
		controller.addGradetoRubric(r, studentGrade1);
		
		double stdDev = Controller.getGradeStdDev(r, 2);
		
		// mean = 3
		/* (4 - 3)^2 = 1^2
		 * (2 - 3)^2 = -1^2
		 * (2 - 3)^2 = -1^2
		 * (4 - 3)^2 =  1^2    === 1,1,1,1,1,1,1,1
		 * (2 - 3)^2 = -1^2
		 * (4 - 3)^2 = 1^2
		 * (4 - 3)^2 = 1^2
		 * (2 - 3)^2 = -1^2
		 	Std Dev should be 1*/
		assertEquals(stdDev,1);
	}
	
	//Show max Grade
	@Test
	public void TestMaxGrade() {
		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test", criterionList);
		
		StudentGrade studentGrade = controller.createGrade(5, 2, 2, 4); // 12
		StudentGrade studentGrade1 = controller.createGrade(2, 4, 1, 2);// 12
		
		controller.addGradetoRubric(r, studentGrade);
		controller.addGradetoRubric(r, studentGrade1);
		
		double max = Controller.getMaxGrade(r, 2);
		assertEquals(max, 5);
	}
	
	// Show min Grade
	@Test
	public void TestMinGrade() {
		Criterion c1 = new Criterion("Design");
		Criterion c2 = new Criterion("Implentation");
		Criterion c3 = new Criterion("Testing");
		Criterion c4 = new Criterion("Documentation");
		
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		
		criterionList.add(c1);
		criterionList.add(c2);
		criterionList.add(c3);
		criterionList.add(c4);
		
		Rubric r = controller.createRubric("Test", criterionList);
		
		StudentGrade studentGrade = controller.createGrade(5, 2, 2, 4); // 12
		StudentGrade studentGrade1 = controller.createGrade(2, 4, 1, 2);// 12
		
		controller.addGradetoRubric(r, studentGrade);
		controller.addGradetoRubric(r, studentGrade1);
		
		double min = Controller.getMinGrade(r, 2);
		assertEquals(min, 1);
	}
}
