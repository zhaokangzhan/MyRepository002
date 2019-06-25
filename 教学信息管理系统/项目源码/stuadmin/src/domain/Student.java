package domain;

//CREATE TABLE `student` (
//		  `Id` int(11) NOT NULL AUTO_INCREMENT,
//		  `uuid` varchar(255) NOT NULL DEFAULT '',
//		  `stu_id` varchar(255) NOT NULL DEFAULT '',
//		  `stu_name` varchar(255) DEFAULT NULL,
//		  `stu_idcard` varchar(255) NOT NULL DEFAULT '',
//		  `active` varchar(255) NOT NULL DEFAULT '0',
//		  PRIMARY KEY (`Id`)
//		) ENGINE=MyISAM DEFAULT CHARSET=utf8;

public class Student {
	
	private int id;
	private String student_uuid;
	private String student_id;
	private String student_name;
	private String student_idcard;
	private String student_active;
	
	

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStudent_uuid() {
		return student_uuid;
	}


	public void setStudent_uuid(String student_uuid) {
		this.student_uuid = student_uuid;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public String getStudent_idcard() {
		return student_idcard;
	}


	public void setStudent_idcard(String student_idcard) {
		this.student_idcard = student_idcard;
	}


	public String getStudent_active() {
		return student_active;
	}


	public void setStudent_active(String student_active) {
		this.student_active = student_active;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", student_uuid=" + student_uuid + ", student_id=" + student_id + ", student_name="
				+ student_name + ", student_idcard=" + student_idcard + ", student_active=" + student_active + "]";
	}



}
