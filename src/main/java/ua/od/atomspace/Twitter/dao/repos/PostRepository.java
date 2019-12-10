package ua.od.atomspace.Twitter.dao.repos;

import org.springframework.data.repository.CrudRepository;
import ua.od.atomspace.Twitter.dao.models.Post;

import java.util.Iterator;

public interface PostRepository extends CrudRepository<Post, Long> {

    Iterable<Post> findAllByTitle(String title);

    //print 10 last created posts
    Iterable<Post> findTop10ByCreatedAt();

}
