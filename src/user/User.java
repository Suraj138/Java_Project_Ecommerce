package user;
public abstract class User {
	String userId = "";
	String password = "";
	String loginStatus = "";

	public User() {
	}

	public User(String userId, String password, String loginStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.loginStatus = loginStatus;
	}
 
	abstract Boolean verifyUser();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
