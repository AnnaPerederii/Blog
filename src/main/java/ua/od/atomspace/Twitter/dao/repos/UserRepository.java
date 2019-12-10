package ua.od.atomspace.Twitter.dao.repos;

import org.aspectj.weaver.ast.ITestVisitor;
import org.springframework.data.repository.CrudRepository;
import ua.od.atomspace.Twitter.dao.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

    //print the youngest and the eldest user
    //select user findTopOrderByAgeAsc
    User findFirstByAge();

    User findDistinctFirstByAge();

    //print all users between 25 and 40 years
    Iterable<User> findAllByAgeBetween(int start, int stop);

    //print all users where name without vowels
    Iterable<User> findAllByFirstNameNotLike(String like);
}
