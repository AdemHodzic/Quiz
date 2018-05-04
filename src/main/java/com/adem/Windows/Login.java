package com.adem.Windows;

import java.util.ArrayList;
import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.UserDaoImpl;
import Entities.UserProperties;

public class Login implements Window{

	
	private final int MAIN_MENU_POSITION = 1;
	private final int ADMIN_MENU_POSITION = 5;
	private UserDaoImpl database = new UserDaoImpl();
	
	@Override
	public void start() {

		Scanner input = new Scanner(System.in);
		
		while(true) {
		System.out.println("Welcome! Do you want to log in or register ?"
				+ "\n1. Log in"
				+ "\n2. Register"
				+ "\n3. Quit");
		int choice;
		
		do {
			choice = input.nextInt();
		}while(choice < 1 || choice > 3);
		
		if(choice == 1)
			login();
		else if(choice == 2)
			register();
		else
			quit();
		}
	}
	
	private void login() {
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
				Controller.start(ADMIN_MENU_POSITION);
			else
				Controller.start(MAIN_MENU_POSITION);
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

	private void register() {
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
			Controller.start(MAIN_MENU_POSITION);
		}else
			System.out.println("There is already an account with those properties!\nTry again.");
	}
	
	private void quit() {
		System.exit(0);
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
