package ua.od.atomspace.Twitter.dao.repos;

import org.springframework.data.repository.CrudRepository;
import ua.od.atomspace.Twitter.dao.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
}
