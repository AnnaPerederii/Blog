package ua.od.atomspace.Twitter.services;

import ua.od.atomspace.Twitter.dao.models.Post;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;


public interface PostService {

    Post delete(Long id) throws ObjectNotFoundException;

    Post save(Post post);

    Iterable <Post> findAll();
}
