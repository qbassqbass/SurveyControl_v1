package entity;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface User_answerDAO extends CrudRepository<User_answer, Long> {

}
