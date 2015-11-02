package singleton.reader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import concreateClasses.GradedWork;
import concreateClasses.Student;
import abstractClasses.IStudentDataReader;

public class StudentDataJSONReader extends IStudentDataReader {

	protected static IStudentDataReader uniqueInstanceJSON = null;
	// Private Constructor to create Singleton pattern
	private StudentDataJSONReader() {
	}

	// Return already created unique instance
	public static IStudentDataReader getInstance() {
		if(uniqueInstanceJSON == null){
			uniqueInstanceJSON = new StudentDataJSONReader();
		}
		return uniqueInstanceJSON;
	}
	
	@Override
	public String getFilePath() {
		return filePath;
	}

	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> readStudentData() {
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		
		try {
			// Read json file
			obj = parser.parse(new FileReader(getFilePath()));
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		JSONObject jsonRootObject = (JSONObject) obj;
		JSONObject gradeBookObject = (JSONObject) jsonRootObject.get("GradeBook");
		
		JSONObject gradesObject = (JSONObject) gradeBookObject.get("Grades");
		List<Student> studentList = new ArrayList<Student>();
		JSONArray studentObjectList = null;
		
		if(gradesObject.get("Student") instanceof JSONObject){
			JSONObject jsonObject = (JSONObject) gradesObject.get("Student");
			studentObjectList = new JSONArray();
			studentObjectList.add(jsonObject);
		}else{
			studentObjectList =  (JSONArray) gradesObject.get("Student");
		}
		
		if(studentObjectList != null)
		for(int i=0; i< studentObjectList.size(); i++){
			Student s = new Student();
			JSONObject student = (JSONObject)studentObjectList.get(i);
			
			// Set student Name
			String name = (String) student.get("Name");
			if(name != null) s.setName(name);
			
			// Set student ID
			String id = (String) student.get("ID");
			if(id != null) s.setId(id);
			
			// Set student Assigned Work
			Map<String, List<GradedWork>> assignedWork = new LinkedHashMap<String, List<GradedWork>>();
			if(student.get("AssignedWork") instanceof JSONArray){
				JSONArray assignedObjectList =  (JSONArray) student.get("AssignedWork");
				if(assignedObjectList != null)
				for(int j=0; j < assignedObjectList.size(); j++){
					
					JSONObject item = (JSONObject) assignedObjectList.get(j);	
					Map<String, List<GradedWork>> assignedWorktemp = getAssignedWork(item);
					assignedWork.putAll(assignedWorktemp);

				}// for loop assigned object list
			}else{
				JSONObject item = (JSONObject) student.get("AssignedWork");
				Map<String, List<GradedWork>> assignedWorktemp = getAssignedWork(item);
				assignedWork.putAll(assignedWorktemp);
			}
			// Set Assigned work
			s.setAssignedWork(assignedWork);
			
			// Add student to student list
			studentList.add(s);
		}
					
		return studentList;
	}

	private GradedWork getGradedWork(JSONObject gradedWorkObject){
		GradedWork gradedWork = new GradedWork();
		// Set Name of graded work
		String nameitem = (String) gradedWorkObject.get("Name");
		gradedWork.setName(nameitem);
		// Set Grade of graded work
		String gradeitem = (String) gradedWorkObject.get("Grade");
		gradedWork.setGrade(gradeitem);
		return gradedWork;
	}
	
	private Map<String, List<GradedWork>> getAssignedWork(JSONObject item){
		Map<String, List<GradedWork>> assignedWork = new LinkedHashMap<String, List<GradedWork>>();
		// Set Category
		String category = (String) item.get("-category");
		
		// Set Graded Work
		List<GradedWork> gradedWorkList = new ArrayList<GradedWork>();
		
		if( item.get("GradedWork") instanceof JSONArray){
			JSONArray gradedWorkObjectList = (JSONArray) item.get("GradedWork");
			
			if(gradedWorkObjectList != null)
			for(int k = 0; k < gradedWorkObjectList.size(); k++){
				
				JSONObject gradedWorkObject = (JSONObject) gradedWorkObjectList.get(k);
				GradedWork gradedWork = getGradedWork(gradedWorkObject);
				// Add to graded work list
				gradedWorkList.add(gradedWork);
			}
		}else {
			
			JSONObject gradedWorkObject = (JSONObject) item.get("GradedWork");
			GradedWork gradedWork = getGradedWork(gradedWorkObject);
			// Add to graded work list
			gradedWorkList.add(gradedWork);
		}
		// Add to assigned work list
		assignedWork.put(category, gradedWorkList);
		return assignedWork;
	}
	
	@Override
	public String readClass(){
		JSONParser parser = new JSONParser();
		Object obj = null;
		
		try {
			// Read json file
			obj = parser.parse(new FileReader(getFilePath()));
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		JSONObject jsonRootObject = (JSONObject) obj;
		JSONObject gradeBookObject = (JSONObject) jsonRootObject.get("GradeBook");
		String className = (String) gradeBookObject.get("-class");
		return className;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, String> readGradingSchema(){
		JSONParser parser = new JSONParser();
		Object obj = null;
		
		try {
			// Read json file
			obj = parser.parse(new FileReader(getFilePath()));
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		JSONObject jsonRootObject = (JSONObject) obj;
		JSONObject gradeBookObject = (JSONObject) jsonRootObject.get("GradeBook");
		JSONObject gradingSchemaObject = (JSONObject) gradeBookObject.get("GradingSchema");
		Map<String, String> gradedItemList = new LinkedHashMap<String, String>();
		JSONArray gradedItemObjectList = null;
		if(gradingSchemaObject.get("GradeItem") instanceof JSONObject){
			JSONObject gradedItem = (JSONObject) gradingSchemaObject.get("GradeItem");
			gradedItemObjectList = new JSONArray();
			gradedItemObjectList.add(gradedItem);
		}else{
			gradedItemObjectList = (JSONArray) gradingSchemaObject.get("GradeItem");
		}
		
		for(int i=0; i< gradedItemObjectList.size(); i++){
			JSONObject item = (JSONObject) gradedItemObjectList.get(i);
			String category = (String) item.get("Category");
			String percentage = (String) item.get("Percentage");
			gradedItemList.put(category, percentage);
		}
		return gradedItemList;
	}

}
