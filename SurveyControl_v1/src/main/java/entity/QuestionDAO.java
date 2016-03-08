package entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface QuestionDAO extends CrudRepository<Question, Long> {
	
	public List<Question> findBySurveyId(long id);
}
