package com.adem.Windows;

import java.util.Scanner;

import com.adem.Controller.Controller;

import Entities.User;
import events.CheckHighScoreCommand;
import events.CheckMyStatsCommand;
import events.Invoker;
import events.LogOutCommand;
import events.PlayGameCommand;

public class MainMenu implements Window{
	
	private User user;
	private Invoker invoker;
	
	@Override
	public void start() {
		this.user = Controller.getUser();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome " + user.getName() + "!"
					+ "\nSelect what do you want to do: "
					+ "\n1.Play a game"
					+ "\n2.Check high scores"
					+ "\n3.Check my stats"
					+ "\n4.Log out"
					+ "\n5.Quit");
			int choice;
			do {
				choice = input.nextInt();
			}while(choice < 1 | choice > 5);
		
			switch(choice) {
				case 1:
					invoker = new Invoker(new PlayGameCommand());
					invoker.execute();
					break;
				case 2:
					invoker = new Invoker(new CheckHighScoreCommand());
					invoker.execute();
					break;
				case 3:
					invoker = new Invoker(new CheckMyStatsCommand());
					invoker.execute();
					break;
				case 4:
					invoker = new Invoker(new LogOutCommand());
					invoker.execute();
					break;
				case 5:
					System.out.println("Thank you for using my app.");
					System.exit(0);
					break;
			}
		}
		
	}

}
