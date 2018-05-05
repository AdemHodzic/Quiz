package com.adem.Windows;

import com.adem.Controller.Controller;

import Entities.User;

public class MyStats implements Window{

	private User user;
	
	public MyStats() {}
	
	@Override
	public void start() {
		this.user = Controller.getUser();
		String[] scores = user.getResults().split(",");
		System.out.println("=Y O U R  S T A T S=");
		System.out.println("=Name: " + user.getName());
		System.out.println("=Best score: " + user.getBest());
		System.out.print("=Scores so far: ");
		for(String score : scores) {
			System.out.print(score + " ");
		}
		System.out.println();
		System.out.println("====================");
	}
	
	
}
