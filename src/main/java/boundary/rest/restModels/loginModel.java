package boundary.rest.restModels;

import java.io.Serializable;

public class loginModel implements Serializable {

	private String password;

	private String username;

	public loginModel(){
		//empty constructor so that javax.json can create an instance of this object
	}

	public loginModel(String password, String username) {
		this.password = password;
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
