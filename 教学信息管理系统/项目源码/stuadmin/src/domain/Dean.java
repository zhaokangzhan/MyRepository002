package domain;


public class Dean {
	
	private int id;
	private String dean_uuid;
	private String dean_id;
	private String dean_name;
	private String dean_idcard;
	private String dean_active;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDean_uuid() {
		return dean_uuid;
	}


	public void setDean_uuid(String dean_uuid) {
		this.dean_uuid = dean_uuid;
	}


	public String getDean_id() {
		return dean_id;
	}


	public void setDean_id(String dean_id) {
		this.dean_id = dean_id;
	}


	public String getDean_name() {
		return dean_name;
	}


	public void setDean_name(String dean_name) {
		this.dean_name = dean_name;
	}


	public String getDean_idcard() {
		return dean_idcard;
	}


	public void setDean_idcard(String dean_idcard) {
		this.dean_idcard = dean_idcard;
	}


	public String getDean_active() {
		return dean_active;
	}


	public void setDean_active(String dean_active) {
		this.dean_active = dean_active;
	}


	@Override
	public String toString() {
		return "Dean [id=" + id + ", dean_uuid=" + dean_uuid + ", dean_id=" + dean_id + ", dean_name=" + dean_name
				+ ", dean_idcard=" + dean_idcard + ", dean_active=" + dean_active + "]";
	}


	

}
