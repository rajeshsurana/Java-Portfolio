package concreateClasses;

import java.util.List;
import java.util.Map;

public class GradeBook {
	private String className;
	private Map<String, String> gradingSchema;
	private List<Student> studentList;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Map<String, String> getGradingSchema() {
		return gradingSchema;
	}
	public void setGradingSchema(Map<String, String> gradingSchema) {
		this.gradingSchema = gradingSchema;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void calcualteFinalGrades(){
		for(int i=0; i< studentList.size(); i++){
			Student s = studentList.get(i);
			//Boolean numberGrade = false;
			Float total = 0f;
			Map<String, List<GradedWork>> assignedWork = s.getAssignedWork();
			//boolean checked = true;
			for(String gradeItem: gradingSchema.keySet()){
				if(assignedWork.containsKey(gradeItem)){
					List<GradedWork> gradedWorkList = assignedWork.get(gradeItem);
					Float temp = 0f;
//					if(checked){
//						String grade = gradedWorkList.get(0).getGrade();
//						checked = false;
//						try{
//							Float.parseFloat(grade);
//							numberGrade = true;
//						}catch(Exception e){
//							numberGrade = false;
//						}
//					}
					int j = 0;
					for(j=0; j< gradedWorkList.size(); j++){
						temp += getTrueGrade(gradedWorkList.get(j).getGrade());
					}
					total += (temp/(j*100f))*getTrueGrade(gradingSchema.get(gradeItem));
				}
			}
			
			String finalGrade = calculateFinalGrade(total);
			s.setFinalGrade(finalGrade);
		}
	}
	
	public boolean isValid(){
		for(int i=0; i< studentList.size(); i++){
			Student s = studentList.get(i);
			Map<String, List<GradedWork>> assignedWork = s.getAssignedWork();
			for(String gradeItem: gradingSchema.keySet()){
				if(!assignedWork.containsKey(gradeItem)){
					return false;
				}
				List<GradedWork> gradedWorkList = assignedWork.get(gradeItem);
				int j = 0;
				for(j=0; j< gradedWorkList.size(); j++){
					Float temp = getTrueGrade(gradedWorkList.get(j).getGrade());
					if(temp > 100 || temp < 0 ){
						return false;
					}
				}
			}			
		}
		return true;
	}
	
	private Float getTrueGrade(String grade){
		Float gradeFloat = 0f;
		try {
			gradeFloat = Float.parseFloat(grade); 
		} catch (Exception e) {
			char startingLetter = grade.charAt(0);
			switch (startingLetter) {
			case 'A':
			case 'a':
				gradeFloat = 95.0f;
				break;
			case 'B':
			case 'b':
				gradeFloat = 84.0f;
			case 'C':
			case 'c':
				gradeFloat = 72.5f;
			case 'D':
			case 'd':
				gradeFloat = 65.0f;
			case 'E':
			case 'e': 
				gradeFloat = 55.0f;
			default:
				break;
			}
		}
		return gradeFloat;
	}
		
	private String calculateFinalGrade(Float grade){
		String gradeFinal = null;
			if(grade >=99f){
				gradeFinal = "A+";
			}else if(grade >= 95f){
				gradeFinal = "A";
			}else if(grade >= 90f){
				gradeFinal = "A-";
			}else if(grade >= 87f){
				gradeFinal = "B+";
			}else if(grade >= 84f){
				gradeFinal = "B";
			}else if(grade >= 80f){
				gradeFinal = "B-";
			}else if(grade >= 75f){
				gradeFinal = "C+";
			}else if(grade >= 70f){
				gradeFinal = "C";
			}else if(grade >= 60f){
				gradeFinal = "D";
			}else if(grade < 60f){
				gradeFinal = "E";
			}
		return gradeFinal;
	}
	
}
