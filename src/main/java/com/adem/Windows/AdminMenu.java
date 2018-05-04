package com.adem.Windows;

import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.QuestionDAOImpl;
import DAO.UserDaoImpl;
import Entities.Answer;
import Entities.Question;
import Entities.UserProperties;

public class AdminMenu implements Window{
	
	private QuestionDAOImpl database = new QuestionDAOImpl();
	private UserDaoImpl userDatabase = new UserDaoImpl();
	private final int LOGIN_POSITION = 0; //It would be better if I used Enum but oh well..
	
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
					addQuestion();
					break;
				case 2:
					editQuestion();
					break;
				case 3:
					deleteUser();
					break;
				case 4:
					logout();
					break;
				case 5:
					quit();
					break;
			}
		}
	}
	
	private void addQuestion() {
		Question question = new Question();
		
		Scanner input = new Scanner(System.in);
		
		editQuestionText(question);
		editAnswers(question);
		
		database.addQuestion(question);
		
	}

	private void editQuestion() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id of the question you want to change: ");
		int id = input.nextInt();
		Question question = database.getQuestion(id);
		
		editQuestionText(question);
		editAnswers(question);
		
		database.editQuestion(question);
	}
	
	

	private void deleteUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the user you want to delete: ");
		String name = input.nextLine();
		UserProperties props = new UserProperties();
		props.setName(name);
		
		userDatabase.deleteUser(props);
	}
	
	private void logout() {
		Controller.start(LOGIN_POSITION);
	}
	
	private void quit() {
		System.exit(0);
	}
	
	private void editAnswers(Question question) {
		Scanner input = new Scanner(System.in);

		Answer[] arr = question.getAnswers();
		boolean correctInserted = false;
		for(int i = 0;i<4;i++) {
			Answer ans = arr[i];
			System.out.println("Enter the text and answer will be changed (enter -1 to keep it same): ");
			String ansText = input.nextLine();
			if(!ansText.equals("-1".trim())) {
				ans.setText(ansText);
			}
			
			if(!correctInserted) {
				System.out.println("Is this answer correct (y/n)? ");
				String yesorno = input.nextLine();
				if(yesorno.equals("y")) {
					ans.setCorrect(true);
					correctInserted = true;
				}else{
					ans.setCorrect(false);
				}
			}
			
		}
	
	}

	private void editQuestionText(Question question) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the text and quesiton will be changed (enter -1 to keep it same): ");
		String text = input.nextLine();
		if(!text.equals("-1".trim())){
			question.setText(text);
		}
	}
}
