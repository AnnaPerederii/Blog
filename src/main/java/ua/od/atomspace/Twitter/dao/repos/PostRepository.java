package ua.od.atomspace.Twitter.dao.repos;

import org.springframework.data.repository.CrudRepository;
import ua.od.atomspace.Twitter.dao.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
