package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entities.Answer;
import Entities.Question;

public class QuestionDAOImpl implements QuestionsDAO{

	private Connection conn = ConnectionManager.getInstance().getConnection();

	public QuestionDAOImpl(){}
	
	@Override
	public void addQuestion(Question question) {
		String query = "INSERT INTO questions(text, correct, wrong1, wrong2, wrong3) VFALUES(?,?,?,?,?)";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			Answer[] answers = question.getAnswers();
			stmt.setString(1, question.getText());
			stmt.setString(2, answers[0].getText());
			stmt.setString(3, answers[1].getText());
			stmt.setString(4, answers[2].getText());
			stmt.setString(5, answers[3].getText());
			
			if(stmt.executeUpdate() == 1)
				System.out.println("Question sucesfully added");
		} catch (Exception e) {
		}
	}

	@Override
	public void editQuestion(Question question) {
		String query = "UPDATE questions SET text=?, correct=?, wrong1=?, wrong2=?, wrong3=? WHERE id=?";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			Answer[] answers = question.getAnswers();
			stmt.setString(1, question.getText());
			stmt.setString(2, answers[0].getText());
			stmt.setString(3, answers[1].getText());
			stmt.setString(4, answers[2].getText());
			stmt.setString(5, answers[3].getText());
			stmt.setInt(6, question.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public Question getQuestion(Question question) {
		String query = "SELECT * FROM questions WHERE question=?";
		Question temp = new Question();
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, question.getText());
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			String correctText = rs.getString("correct"); 
			String wrong1 = rs.getString("wrong1"); 
			String wrong2 = rs.getString("wrong2"); 
			String wrong3 = rs.getString("wrong3"); 
			int id= rs.getInt("id");
			Answer[] answers = makeAnswers(correctText,wrong1,wrong2,wrong3);

			temp.setText(rs.getString("text"));
			temp.setAnswers(answers);
			temp.setId(id);
		} catch (Exception e) {
		}
		return temp;
	}
	
	@Override
	public Question getQuestion(int id) {
		String query = "SELECT * FROM questions WHERE id=?";
		Question temp = new Question();
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			String correctText = rs.getString("correct"); 
			String wrong1 = rs.getString("wrong1"); 
			String wrong2 = rs.getString("wrong2"); 
			String wrong3 = rs.getString("wrong3"); 
			
			Answer[] answers = makeAnswers(correctText,wrong1,wrong2,wrong3);

			temp.setText(rs.getString("text"));
			temp.setAnswers(answers);
			temp.setId(id);
		} catch (Exception e) {
		}
		return temp;
	}

	@Override
	public ArrayList<Question> getAllQuestion() {
		ArrayList<Question> list = new ArrayList<>();
		
		String query = "SELECT * FROM questions";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			
				Question temp = new Question();

				String correctText = rs.getString("correct"); 
				String wrong1 = rs.getString("wrong1"); 
				String wrong2 = rs.getString("wrong2"); 
				String wrong3 = rs.getString("wrong3"); 
				int id = rs.getInt("id");
				
				Answer[] answers = makeAnswers(correctText,wrong1,wrong2,wrong3);
	
				temp.setText(rs.getString("text"));
				temp.setAnswers(answers);
				temp.setId(id);
				list.add(temp);
			}
		} catch (Exception e) {
		}
		
		return list;
	}


	private Answer[] makeAnswers(String correctText, String wrong1, String wrong2, String wrong3) {
		
		Answer correct = new Answer();
		correct.setText(correctText);
		correct.setCorrect(true);
		
		Answer wrongOne = new Answer();
		correct.setText(wrong1);
		correct.setCorrect(false);
		
		Answer wrongTwo = new Answer();
		correct.setText(wrong2);
		correct.setCorrect(false);
		
		Answer wrongThree = new Answer();
		correct.setText(wrong3);
		correct.setCorrect(false);
		
		Answer[] answers = {correct, wrongOne, wrongTwo, wrongThree};
		
		return answers;
	}

	

}
