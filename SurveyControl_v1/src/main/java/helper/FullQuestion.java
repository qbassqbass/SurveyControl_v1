package helper;

import entity.Question;

import java.util.ArrayList;
import java.util.List;

import entity.Possible_answer;

public class FullQuestion {
	
	private Question question;
	private List<Possible_answer> answers;
	
	public FullQuestion(Question question){
		this.question = question;
		this.answers = new ArrayList<Possible_answer>();
	}
	
	public void addAnswer(Possible_answer answer){
		this.answers.add(answer);
	}
	
	public void addAnswers(List<Possible_answer> answerList){
		this.answers.addAll(answerList);
	}
	
	public Question getQuestion(){
		return this.question;
	}
	
	public List<Possible_answer> getAnswers(){
		return this.answers;
	}
}
