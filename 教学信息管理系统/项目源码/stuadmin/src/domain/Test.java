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

public class Test {
	
	private int id;
	private String test_uuid;
	private String test_question;
	private String test_select_a;
	private String test_select_b;
	private String test_select_c;
	private String test_select_d;
	private String test_answer;
	private String test_explain;

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTest_uuid() {
		return test_uuid;
	}


	public void setTest_uuid(String test_uuid) {
		this.test_uuid = test_uuid;
	}


	public String getTest_question() {
		return test_question;
	}


	public void setTest_question(String test_question) {
		this.test_question = test_question;
	}


	public String getTest_select_a() {
		return test_select_a;
	}


	public void setTest_select_a(String test_select_a) {
		this.test_select_a = test_select_a;
	}


	public String getTest_select_b() {
		return test_select_b;
	}


	public void setTest_select_b(String test_select_b) {
		this.test_select_b = test_select_b;
	}


	public String getTest_select_c() {
		return test_select_c;
	}


	public void setTest_select_c(String test_select_c) {
		this.test_select_c = test_select_c;
	}


	public String getTest_select_d() {
		return test_select_d;
	}


	public void setTest_select_d(String test_select_d) {
		this.test_select_d = test_select_d;
	}


	public String getTest_answer() {
		return test_answer;
	}


	public void setTest_answer(String test_answer) {
		this.test_answer = test_answer;
	}


	public String getTest_explain() {
		return test_explain;
	}


	public void setTest_explain(String test_explain) {
		this.test_explain = test_explain;
	}


	@Override
	public String toString() {
		return "Test [id=" + id + ", test_uuid=" + test_uuid + ", test_question=" + test_question + ", test_select_a="
				+ test_select_a + ", test_select_b=" + test_select_b + ", test_select_c=" + test_select_c
				+ ", test_select_d=" + test_select_d + ", test_answer=" + test_answer + ", test_explain=" + test_explain
				+ "]";
	}


	

	
	

}
