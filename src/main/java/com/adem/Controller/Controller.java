package com.adem.Controller;

import com.adem.Windows.Window;

import Entities.User;

public class Controller {
	
	
	private static WindowController windowController;
	
	private static User user;
	
	public Controller() {
		windowController = new WindowController();
	}
	
	public  void start() {
		windowController.start();
	}
	
	public  void start(int index) {
		windowController.start(index);
	}

	public static User getUser() {
		return user;
	}

	public  void setUser(User user) {
		Controller.user = user;
	}
	
	
}
