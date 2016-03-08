/**
 * 
 */
package entity;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jakub
 *
 */
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, String>{
	
	public User findByEmail(String email);
}
