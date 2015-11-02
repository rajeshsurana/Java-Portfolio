package concreateClasses;


public class GradedWork {
	private String name;
	private String grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "GradedWork [name=" + name + ", grade=" + grade + "]";
	}

}
