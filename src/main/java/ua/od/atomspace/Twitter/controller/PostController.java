package ua.od.atomspace.Twitter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.od.atomspace.Twitter.dao.models.Post;
import ua.od.atomspace.Twitter.dao.repos.PostRepository;
import ua.od.atomspace.Twitter.services.PostService;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/api/posts")
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(path = "/allPosts")
    @ResponseBody
    public Iterable<Post> getAllPosts(){
        return postService.findAll();
    }


    @PostMapping(path = "/addPost")
    @ResponseBody
    public String createPost(@RequestBody Post post){
        postService.save(post);
        log.info("Change password for param + username: {}", post);
        return "Post was created";
    }

    @PutMapping
    @ResponseBody
    public Post changeTitle(@RequestBody Post post, @RequestParam String title){
        post.setTitle(title);
        log.info("Update info - new title: {}", post.getTitle());
        return post;
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseBody
    public String delete(@PathVariable long id) throws ObjectNotFoundException {
        Post result = postService.delete(id);
        return "Post was deleted";
    }

}
