package entity;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface SurveyDAO extends CrudRepository<Survey, Long> {

	public Survey findById(long id);
}
