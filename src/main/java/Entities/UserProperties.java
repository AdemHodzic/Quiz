package Entities;

public class UserProperties {
	
	private int id;
	private String name;
	private String password;
	private String results; //CSF
	private int best;
	
	public UserProperties(){
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}
	
	
	
}
