package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Possible_answer;
import entity.Possible_answerDAO;
import entity.Question;
import entity.QuestionDAO;
import entity.Survey;
import entity.SurveyDAO;
import helper.FullQuestion;
import helper.FullSurvey;

@Controller
public class UserController {
	
	@RequestMapping("/justsurvey")
	@ResponseBody
	public Survey getJustSurvey(long id){
		try{
			Survey survey = surveyDAO.findOne(id);
			return survey;
		}catch(Exception ex){
			return new Survey(0);
		}
	}
	
	@RequestMapping("/fullquestion")
	@ResponseBody
	public FullQuestion getFullQuestion(long id){
		Question question = questionDAO.findOne(id);
		FullQuestion fq = new FullQuestion(question);
//		getAnswersByQuestionId(id);
		fq.addAnswers(getAnswersByQuestionId(id));
		return fq;
	}
	
	@RequestMapping("/fullsurvey")
	@ResponseBody
	public FullSurvey getFullSurvey(long id){
		Survey survey = surveyDAO.findOne(id);
		FullSurvey fs = new FullSurvey(survey);
		for(Question q : getSurvey(id)){
			fs.addQuestion(getFullQuestion(q.getId()));
		}
		return fs;
	}
	
	@RequestMapping("/answer-by-question-id")
	@ResponseBody
	public List<Possible_answer> getAnswersByQuestionId(long id){
		List<Possible_answer> answers = answerDAO.findByQuestionId(id);
//		for(Possible_answer a : answers){
//			a.setQuestion(null);
//		}
		return answers;
	}

	@RequestMapping("/survey")
	@ResponseBody
	public List<Question> getSurvey(long id){
//		Survey survey = surveyDAO.findOne(id);
		List<Question> questions = questionDAO.findBySurveyId(id);
		return questions;
	}
	
	@RequestMapping("/question")
	@ResponseBody
	public Question getQuestion(long id){
		try{
			Question question = questionDAO.findOne(id);
			return question;
		}catch(Exception ex){
			return new Question(0, new Survey(0), ex.toString());
		}
	}
	
	@RequestMapping("/questions")
	@ResponseBody
	public List<Question> getQuestions(){
		try{
			List<Question> questions = (List<Question>) questionDAO.findAll();
			return questions;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	@Autowired
	private SurveyDAO surveyDAO;
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private Possible_answerDAO answerDAO;
}
