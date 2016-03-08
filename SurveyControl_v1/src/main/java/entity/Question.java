package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="surveyid")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private Survey survey;
	
	@NotNull
	private String question;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Question(){}
	
	public Question(long id){
		this.id = id;
	}
	
	public Question(long id, Survey survey, String question){
		this(id);
		this.survey = survey;
		this.question = question;
	}
}
