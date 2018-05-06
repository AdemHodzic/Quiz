package events;

import java.util.Scanner;

import DAO.QuestionDAOImpl;
import Entities.Answer;
import Entities.Question;

public class EditQuestionCommand implements Command{

	private QuestionDAOImpl database = new QuestionDAOImpl();

	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id of the question you want to change: ");
		int id = input.nextInt();
		Question question = database.getQuestion(id);
		
		editQuestionText(question);
		editAnswers(question);
		
		database.editQuestion(question);
	}
	
	private void editAnswers(Question question) {
		Scanner input = new Scanner(System.in);

		Answer[] arr = question.getAnswers();
		for(int i = 0;i<4;i++) {
			Answer ans = arr[i];
			if(i == 0)
				System.out.println("Enter the correct answer or press -1 to keep it same as before: ");
			else
			System.out.println("Enter the text and answer will be changed (enter -1 to keep it same): ");
			String ansText = input.nextLine();
			
			if(!ansText.equals("-1".trim())) {
				ans.setText(ansText);
			}
			
			if(i == 0)
				ans.setCorrect(true);
			else
				ans.setCorrect(false);
		}
		
		question.setAnswers(arr);
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
