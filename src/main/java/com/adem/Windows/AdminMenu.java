package com.adem.Windows;

import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.QuestionDAOImpl;
import DAO.UserDaoImpl;
import Entities.Answer;
import Entities.Question;
import Entities.UserProperties;
import events.AddQuesitonCommand;
import events.DeleteUserCommand;
import events.EditQuestionCommand;
import events.Invoker;
import events.LogOutCommand;

public class AdminMenu implements Window{
	
	private QuestionDAOImpl database = new QuestionDAOImpl();
	private final int LOGIN_POSITION = 0; //It would be better if I used Enum but oh well..
	private Invoker invoker;
	
	public AdminMenu() {}
	
	@Override
	public void start() {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Admin menu initialized:"
					+ "\n1. Add question"
					+ "\n2. Edit question"
					+ "\n3. Delete user"
					+ "\n4. Log out"
					+ "\n5. Quit");
			
			int choice;
			do {
				choice = input.nextInt();
			}while(choice < 1 | choice > 5);
			
			switch(choice) {
				case 1:
					invoker = new Invoker(new AddQuesitonCommand());
					invoker.execute();
					break;
				case 2:
					invoker = new Invoker(new EditQuestionCommand());
					invoker.execute();
					break;
				case 3:
					invoker = new Invoker(new DeleteUserCommand());
					invoker.execute();
					break;
				case 4:
					invoker = new Invoker(new LogOutCommand());
					invoker.execute();
					break;
				case 5:
					quit();
					break;
			}
		}
	}

	private void quit() {
		System.exit(0);
	}
	
}
