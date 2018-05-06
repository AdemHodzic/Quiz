package com.adem.Windows;

import java.util.ArrayList;
import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.UserDaoImpl;
import Entities.User;
import Entities.UserProperties;
import events.Invoker;
import events.LoginCommand;
import events.RegisterCommand;

public class Login implements Window{

	
	private final int MAIN_MENU_POSITION = 1;
	private final int ADMIN_MENU_POSITION = 5;
	private UserDaoImpl database = new UserDaoImpl();
	private Invoker invoker;
	
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
		
		if(choice == 1) {
			invoker = new Invoker(new LoginCommand());
			invoker.execute();
		}else if(choice == 2) {
			invoker = new Invoker(new RegisterCommand());
			invoker.execute();
		}else
			quit();
		}
	}
	
	private void quit() {
		System.out.println("See you another time.");
		System.exit(0);
	}

}
