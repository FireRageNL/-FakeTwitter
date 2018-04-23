package boundary.rest.restModels;

public class kweetModel {

	private String username;

	private String kweetContents;

	public kweetModel(String username, String kweetContents) {
		this.username = username;
		this.kweetContents = kweetContents;
	}

	public kweetModel(){
		//Constructor for REST
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKweetContents() {
		return kweetContents;
	}

	public void setKweetContents(String kweetContents) {
		this.kweetContents = kweetContents;
	}
}
