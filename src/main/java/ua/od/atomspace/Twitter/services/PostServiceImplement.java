package ua.od.atomspace.Twitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.Twitter.dao.models.Post;
import ua.od.atomspace.Twitter.dao.repos.PostRepository;
import ua.od.atomspace.Twitter.dao.repos.UserRepository;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

@Service
public class PostServiceImplement implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImplement(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post delete(Long id) throws ObjectNotFoundException {
        Post result = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post with such id wasn't found"));
        ;
        postRepository.delete(result);
        return null;
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Iterable<Post> findAll() {
        return null;
    }
}
