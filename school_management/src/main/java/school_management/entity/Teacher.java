package school_management.entity;

public class Teacher {
	private int teacher_id;
	private String teacher_name;
	private String dept_name;
	private double teacher_salary;
	
	
	public Teacher() {		
	}
	public Teacher(int teacher_id, String teacher_name, String dept_name, double teacher_salary) {
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.dept_name = dept_name;
		this.teacher_salary = teacher_salary;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public double getTeacher_salary() {
		return teacher_salary;
	}
	public void setTeacher_salary(double teacher_salary) {
		this.teacher_salary = teacher_salary;
	}
	@Override
	public String toString() {
		return "Teacher [teacher_id : " + teacher_id + " |  teacher_name : " + teacher_name + " |  dept_name : " + dept_name
				+ " |  teacher_salary : " + teacher_salary + " INR ]";
	}
	
	
	
	
}
