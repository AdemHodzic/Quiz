package Entities;

public class User {

	private UserProperties userProperties;
	
	public User() {}
	public User(UserProperties userProperties) {
		this.userProperties = userProperties;
	}
	

	public int getId() {
		return this.userProperties.getId();
	}

	public String getName() {
		return this.userProperties.getName();
	}

	public void setName(String name) {
		this.userProperties.setName(name);
	}

	public String getPassword() {
		return this.userProperties.getPassword();
	}

	public void setPassword(String password) {
		this.userProperties.setPassword(password);
	}

	public String getResults() {
		return this.userProperties.getResults();
	}

	public void setResults(String results) {
		this.userProperties.setResults(results);
	}

	public int getBest() {
		return this.userProperties.getBest();
	}

	public void setBest(int best) {
		this.userProperties.setBest(best);
	}

}
