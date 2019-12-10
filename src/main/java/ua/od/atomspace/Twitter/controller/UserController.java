package ua.od.atomspace.Twitter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.od.atomspace.Twitter.dao.models.User;
import ua.od.atomspace.Twitter.services.UserService;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/allUsers")
    @ResponseBody
    public Iterable<User> getAllUsers(){

        return userService.findAll();
    }


    @PostMapping(path = "/addUser")
    @ResponseBody
    public String create(@RequestBody User user){
        userService.save(user);
        log.info("Created new User: {}", user);
        return "New user was added";
    }

    @PutMapping
    @ResponseBody
    public User changePassword(@RequestBody User user, @RequestParam String password){
        user.setPassword(password);
        log.info("Update info - new password: {}", user.getPassword());
        return user;
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseBody
    public User delete(@PathVariable Long id) throws ObjectNotFoundException{
        User result = userService.delete(id);
        return result;
    }

    @GetMapping(params = {"startAge", "stopAge"})
    @ResponseBody
    public Iterable<User> findByAgeBetween(@RequestParam int startAge,@RequestParam int stopAge){
        return userService.findAllByAgeBetween(startAge,stopAge);
    }

    @GetMapping(path = "/youngest")
    @ResponseBody
    public User findYoungest(){
        return userService.findFirstByAge();
    }

    @GetMapping(path = "/oldest")
    @ResponseBody
    public User findOldest(){
        return userService.findDistinctFirstByAge();
    }

    @GetMapping(path = "/usersWithout/{like}")
    @ResponseBody
    public Iterable<User> findUsersLike(@PathVariable String like){
        return userService.findAllByFirstNameNotLike(like);
    }
}
