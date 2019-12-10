package ua.od.atomspace.Twitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.Twitter.dao.models.Post;
import ua.od.atomspace.Twitter.dao.models.User;
import ua.od.atomspace.Twitter.dao.repos.PostRepository;
import ua.od.atomspace.Twitter.dao.repos.UserRepository;
import ua.od.atomspace.Twitter.dto.PostDto;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostServiceImplement implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostServiceImplement(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public List<PostDto> list() {
        Iterable<Post> list = postRepository.findAll();
        List<PostDto> result = new LinkedList<>();
        list.forEach(post -> result.add(buildToDto(post)));
        return result;
    }

    private Post buildToEntity(PostDto postDto) throws ObjectNotFoundException {
        Post response = new Post();
        User user = userRepository.findById(postDto.getId())
                .orElseThrow(() ->
                        new ObjectNotFoundException("User with id = " + postDto.getId() + " NOT_FOUND"));

        response.setTitle(postDto.getTitle());
        response.setText(postDto.getText());
        response.setUserId(postDto.getUserId());
        response.setCreatedAt(postDto.getCreatedAt());
        return response;
    }

    private PostDto buildToDto(Post post) {
        return PostDto.builder()
                .userId(post.getUserId())
                .createdAt(post.getCreatedAt())
                .text(post.getText())
                .id(post.getId())
                .title(post.getTitle())
                .build();
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

    @Override
    public Iterable<Post> findAllByTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    @Override
    public Iterable<Post> findTop10ByCreatedAt() {
        return postRepository.findTop10ByCreatedAt();
    }


}
