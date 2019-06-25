package domain;

public class PersonCounts {
	
	private int id;
	private String student_counts;
	private String teacher_counts;
	private String dean_counts;
	private String user_counts;
	private String other_counts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_counts() {
		return student_counts;
	}
	public void setStudent_counts(String student_counts) {
		this.student_counts = student_counts;
	}
	public String getTeacher_counts() {
		return teacher_counts;
	}
	public void setTeacher_counts(String teacher_counts) {
		this.teacher_counts = teacher_counts;
	}
	public String getDean_counts() {
		return dean_counts;
	}
	public void setDean_counts(String dean_counts) {
		this.dean_counts = dean_counts;
	}
	public String getUser_counts() {
		return user_counts;
	}
	public void setUser_counts(String user_counts) {
		this.user_counts = user_counts;
	}
	public String getOther_counts() {
		return other_counts;
	}
	public void setOther_counts(String other_counts) {
		this.other_counts = other_counts;
	}
	@Override
	public String toString() {
		return "PersonCounts [id=" + id + ", student_counts=" + student_counts + ", teacher_counts=" + teacher_counts
				+ ", dean_counts=" + dean_counts + ", user_counts=" + user_counts + ", other_counts=" + other_counts
				+ "]";
	}
	
	
}
