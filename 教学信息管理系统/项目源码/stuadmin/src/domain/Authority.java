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

public class Authority {
	
	private int id;
	private String uuid;	
	private String role;
	private String right;
	private String active;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUuid() {
		return uuid;
	}
	
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getRight() {
		return right;
	}


	public void setRight(String right) {
		this.right = right;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Authority [id=" + id + ", uuid=" + uuid + ", role=" + role + ", right=" + right + ", active=" + active
				+ "]";
	}
	

}
