package com.adem.Windows;

import java.util.ArrayList;
import java.util.Scanner;

import com.adem.Controller.Controller;

import DAO.QuestionDAOImpl;
import DAO.UserDaoImpl;
import Entities.Answer;
import Entities.Question;
import Entities.User;
import Entities.UserProperties;

public class Game implements Window{

	private int lives;
	private int index;
	private int points;
	
	private ArrayList<Question> list;
	private QuestionDAOImpl database = new QuestionDAOImpl();
	private UserDaoImpl userDatabase = new UserDaoImpl();
	
	private User user;
	
	public Game() {}
	
	@Override
	public void start() {
		loadQuestions();
		
		this.lives = 3;
		index = 0;
		points = 0;
		
		Scanner input = new Scanner(System.in);
		
		while(this.lives > 0 && index < list.size()) {
			Question question = list.get(index);
			Answer[] answers = question.getAnswers();
			
			System.out.print(question.getText());
			
			printAnswers(answers);
			
			int choice;
			do {
				choice = input.nextInt();
			}while(choice < 1 | choice > 4);
			choice--;
			
			if(answers[choice].isCorrect()) {
				System.out.println("++++++++++++++++++++++++++++++++++++++");
				this.points++;
			}else {
				System.out.println("---------------------------------------" + "   " + this.lives);
				this.lives--;
			}
			index++;
		}
		System.out.println("Your score: " + points);
		writeToDabatabase();
	}

	private void writeToDabatabase() {
		user = Controller.getUser();
		UserProperties props = user.getUserProperties();
		
		if(props.getResults() == null)
			props.setResults("");
		
		props.setResults(props.getResults() + points + ",");
		if( props.getBest() < points )
			props.setBest(points);
		userDatabase.updateUser(props);
	}

	private void printAnswers(Answer[] answers) {
		for(int i = 0;i<answers.length;i++) {
			System.out.println((i+1)+". " + answers[i].getText());
		}
	}

	private void loadQuestions() {
		list = database.getAllQuestion();
	}
}
