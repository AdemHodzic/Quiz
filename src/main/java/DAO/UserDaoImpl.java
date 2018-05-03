package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.UserProperties;

public class UserDaoImpl implements UserDAO{
	
	private Connection conn = ConnectionManager.getInstance().getConnection();

	public UserDaoImpl() {
	}

	public UserProperties getUser(UserProperties properties) {
		UserProperties temp = new UserProperties();
		String query = "SELECT * FROM quiz WHERE name=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			ResultSet rs = stmt.executeQuery();
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String results = rs.getString("results");
			int best = rs.getInt("best");
			
			temp.setId(id);
			temp.setName(name);
			temp.setPassword(password);
			temp.setResults(results);
			temp.setBest(best);
			
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public List<UserProperties> getAlluser() {
		List<UserProperties> list = new ArrayList<>();
		String query = "SELECT * FROM quiz ";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				UserProperties temp = new UserProperties();
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String results = rs.getString("results");
				int best = rs.getInt("best");
				
				temp.setId(id);
				temp.setName(name);
				temp.setPassword(password);
				temp.setResults(results);
				temp.setBest(best);
				
				list.add(temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(UserProperties properties) {
		String query = "INSERT INTO users(name,password) VALUES(?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, properties.getName());
			stmt.setString(2, properties.getPassword());
			
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void deleteUser(UserProperties properties) {
		String query = "DELETE FROM users WHERE name=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, properties.getName());
			
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(UserProperties properties) {
		String query = "UPDATE users SET name=?, password=?, results=?, best=? WHERE id=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, properties.getName());
			stmt.setString(2, properties.getPassword());
			stmt.setString(3, properties.getResults());
			stmt.setInt(4, properties.getBest());
			stmt.setInt(5, properties.getId());
			
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	
}
