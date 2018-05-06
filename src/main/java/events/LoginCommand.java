package events;

import java.util.ArrayList;
import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.UserDaoImpl;
import Entities.User;
import Entities.UserProperties;

public class LoginCommand implements Command{

	private UserDaoImpl database = new UserDaoImpl();
	private Controller controller = new Controller();

	private final int MAIN_MENU_POSITION = 1;
	private final int ADMIN_MENU_POSITION = 5;
	
	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Enter your password: ");
		String password = input.nextLine();
		
		UserProperties userProperties = new UserProperties();
		userProperties.setName(name);
		userProperties.setPassword(password);
		
		if(exists(userProperties))
			if(isAdmin(userProperties))
				controller.start(ADMIN_MENU_POSITION);
			else {
				controller.setUser(new User(database.getUser(userProperties)));
				controller.start(MAIN_MENU_POSITION);
				}
		else
			System.out.println("Wrong input!\nTry Again."); 
	}
	

	private boolean isAdmin(UserProperties userProperties) {
		UserProperties temp = new UserProperties();
		temp.setName("Admin");
		UserProperties admin = database.getUser(temp);
		
		if(admin.getName().equals(userProperties.getName()) && admin.getPassword().equals(userProperties.getPassword()))
			return true;
		return false;
	}
	
	private boolean exists(UserProperties user) {
		ArrayList<UserProperties> list = database.getAlluser();
		for(UserProperties temp : list) {
			//Checks if there is userproperty with same name and password in db
			if(temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword()))
				return true;
		}
		return false;
	}

}
