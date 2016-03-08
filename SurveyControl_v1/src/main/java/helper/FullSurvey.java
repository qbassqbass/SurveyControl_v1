package helper;

import java.util.ArrayList;
import java.util.List;

import entity.Survey;

public class FullSurvey {
	
	private Survey survey;
	private List<FullQuestion> questions;
	
	public FullSurvey(Survey survey){
		this.survey = survey;
		this.questions = new ArrayList<FullQuestion>();
	}
	
	public void addQuestion(FullQuestion fq){
		this.questions.add(fq);
	}
	
	public void addQuestions(List<FullQuestion> fql){
		this.questions.addAll(fql);
	}

	public Survey getSurvey() {
		return survey;
	}

	public List<FullQuestion> getQuestions() {
		return questions;
	}
	

}
