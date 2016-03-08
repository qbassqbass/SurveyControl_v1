package entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface Possible_answerDAO extends CrudRepository<Possible_answer, Long> {

	public List<Possible_answer> findByQuestionId(long id);
}
