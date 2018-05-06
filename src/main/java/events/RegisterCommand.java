package events;

import java.util.ArrayList;
import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.UserDaoImpl;
import Entities.User;
import Entities.UserProperties;

public class RegisterCommand implements Command{

	private UserDaoImpl database = new UserDaoImpl();
	private Controller controller = new Controller();
	private final int MAIN_MENU_POSITION = 1;
	
	
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
		
		if(!exists(userProperties)) {
			database.addUser(userProperties);
			controller.setUser(new User(userProperties));
			controller.start(MAIN_MENU_POSITION);
		}else
			System.out.println("There is already an account with those properties!\nTry again.");
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
