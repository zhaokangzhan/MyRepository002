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

public class Teacher {
	
	private int id;
	private String teacher_uuid;
	private String teacher_id;
	private String teacher_name;
	private String teacher_idcard;
	private String teacher_active;
	
	

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeacher_uuid() {
		return teacher_uuid;
	}


	public void setTeacher_uuid(String teacher_uuid) {
		this.teacher_uuid = teacher_uuid;
	}


	public String getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getTeacher_idcard() {
		return teacher_idcard;
	}


	public void setTeacher_idcard(String teacher_idcard) {
		this.teacher_idcard = teacher_idcard;
	}


	public String getTeacher_active() {
		return teacher_active;
	}


	public void setTeacher_active(String teacher_active) {
		this.teacher_active = teacher_active;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacher_uuid=" + teacher_uuid + ", teacher_id=" + teacher_id + ", teacher_name="
				+ teacher_name + ", teacher_idcard=" + teacher_idcard + ", teacher_active=" + teacher_active + "]";
	}


	
	

}
