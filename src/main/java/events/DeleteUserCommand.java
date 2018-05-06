package events;

import java.util.Scanner;

import DAO.UserDaoImpl;
import Entities.UserProperties;

public class DeleteUserCommand implements Command{

	private UserDaoImpl userDatabase = new UserDaoImpl();
	
	
	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the user you want to delete: ");
		String name = input.nextLine();
		UserProperties props = new UserProperties();
		props.setName(name);
		
		userDatabase.deleteUser(props);
			
	}

}
