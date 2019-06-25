package domain;

/*Id,
 * user_role,
 * user_uuid,
user_id,
user_name,
user_password,
user_idcard,
user_phonenumber,
user_email,
user_active
*/
public class User {
	
	private int id;
	private String user_role;	
	private String user_uuid;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_idcard;
	private String user_phonenumber;
	private String user_email;
	private String user_active;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}


	public String getUser_uuid() {
		return user_uuid;
	}


	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
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


	
	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_idcard() {
		return user_idcard;
	}


	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}


	public String getUser_phonenumber() {
		return user_phonenumber;
	}


	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_active() {
		return user_active;
	}


	public void setUser_active(String user_active) {
		this.user_active = user_active;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", user_role=" + user_role + ", user_uuid=" + user_uuid + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", user_password=" + user_password + ", user_idcard=" + user_idcard
				+ ", user_phonenumber=" + user_phonenumber + ", user_email=" + user_email + ", user_active="
				+ user_active + "]";
	}


	

}
