package com.adem.Controller;

import com.adem.Windows.Window;

import Entities.User;

public class Controller {
	
	
	private static WindowController windowController = new WindowController();
	
	private static User user;
	
	private Controller() {
		
	}
	
	public static void start() {
		windowController.start();
	}
	
	public static void start(int index) {
		windowController.start(index);
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Controller.user = user;
	}
	
	
}
