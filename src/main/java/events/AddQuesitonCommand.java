package events;

import java.util.Scanner;

import DAO.QuestionDAOImpl;
import Entities.Answer;
import Entities.Question;

public class AddQuesitonCommand implements Command{

	private QuestionDAOImpl database = new QuestionDAOImpl();
	
	
	@Override
	public void execute() {
		Question question = new Question();
		
		Scanner input = new Scanner(System.in);
		
		editQuestionText(question);
		editAnswers(question);
		
		database.addQuestion(question);
		
	}
	
	private void editAnswers(Question question) {
		Scanner input = new Scanner(System.in);

		Answer[] arr = new Answer[4];
		for(int i = 0;i<4;i++) {
			Answer ans = new Answer();
			if(i == 0)
				System.out.println("Enter the correct answer: ");
			else
				System.out.println("Enter the text for quesiton number " + (i+1) + ": ");
			
			String ansText = input.nextLine();
			ans.setText(ansText);
			
			if(i == 0)
				ans.setCorrect(true);
			else
				ans.setCorrect(false);
			
			arr[i] = ans;
		}
		question.setAnswers(arr);
	}

	private void editQuestionText(Question question) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the text and quesiton will be changed (enter -1 to keep it same): ");
		String text = input.nextLine();
		question.setText(text);
	}

}
