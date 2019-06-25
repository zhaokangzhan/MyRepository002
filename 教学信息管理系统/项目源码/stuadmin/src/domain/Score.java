package domain;
/*
Id,test_uuid,
test_question,
test_select_a,
test_select_b,
test_select_c,
test_select_d,
test_answer,
test_explain*/

public class Score {
	
	private int id;
	private String score_uuid;
	private String score_id;
	private String user_id;
	private String user_name;
	private String course_name;
	private String score;
	private String score_active;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getScore_uuid() {
		return score_uuid;
	}


	public void setScore_uuid(String score_uuid) {
		this.score_uuid = score_uuid;
	}


	public String getScore_id() {
		return score_id;
	}


	public void setScore_id(String score_id) {
		this.score_id = score_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String getScore_active() {
		return score_active;
	}


	public void setScore_active(String score_active) {
		this.score_active = score_active;
	}


	@Override
	public String toString() {
		return "Score [id=" + id + ", score_uuid=" + score_uuid + ", score_id=" + score_id + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", course_name=" + course_name + ", score=" + score + ", score_active="
				+ score_active + "]";
	}


	
	

}
