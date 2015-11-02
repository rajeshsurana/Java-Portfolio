package concreateClasses;

import java.util.List;
import java.util.Map;

public class Student {
	private String name;
	private String id;
	private Map<String, List<GradedWork>> assignedWork;
	private String finalGrade;

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, List<GradedWork>> getAssignedWork() {
		return assignedWork;
	}

	public void setAssignedWork(Map<String, List<GradedWork>> assignedWork) {
		this.assignedWork = assignedWork;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", assignedWork="
				+ assignedWork + ", finalGrade=" + finalGrade + "]";
	}

}
