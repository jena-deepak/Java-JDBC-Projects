package school_management.entity;

public class Student {
	private int studentId;
	private String studentName;
	private int studentAge;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public Student(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return " [studentId :" + studentId + " |  studentName : " + studentName + " |  studentAge : " + studentAge + "]";
	}
	

}
