package DAO;

import java.util.ArrayList;

import Entities.Question;

public interface QuestionsDAO {
	
	public void addQuestion(Question question);
	public void editQuestion(Question question);
	public Question getQuestion(Question question);
	public Question getQuestion(int id);
	public ArrayList<Question> getAllQuestion();
}
