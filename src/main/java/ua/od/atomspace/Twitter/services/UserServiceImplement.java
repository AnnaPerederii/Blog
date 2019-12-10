package ua.od.atomspace.Twitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.Twitter.dao.models.Post;
import ua.od.atomspace.Twitter.dao.models.User;
import ua.od.atomspace.Twitter.dao.repos.UserRepository;
import ua.od.atomspace.Twitter.dto.PostDto;
import ua.od.atomspace.Twitter.dto.UserDto;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDto> list() {
        Iterable<User> list = userRepository.findAll();
        List<UserDto> result = new LinkedList<>();
        list.forEach(user -> result.add(buildToDto(user)));
        return result;
    }

    private User buildToEntity(UserDto userDto) throws ObjectNotFoundException {
        User response = new User();
        response.setId(userDto.getId());
        response.setFirstName(userDto.getFirstName());
        response.setLastName(userDto.getLastName());
        response.setEmail(userDto.getEmail());
        response.setUsername(userDto.getUsername());
        response.setPassword(userDto.getPassword());
        return response;
    }

    private UserDto buildToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Override
    public User delete(Long id) throws ObjectNotFoundException {
        User result = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User with such id wasn't found"));
        userRepository.deleteById(id);
        return result;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findFirstByAge() {
        return userRepository.findFirstByAge();
    }

    @Override
    public User findDistinctFirstByAge() {
        return userRepository.findDistinctFirstByAge();
    }

    @Override
    public Iterable<User> findAllByAgeBetween(int start, int stop) {
        return userRepository.findAllByAgeBetween(start,stop);
    }

    @Override
    public Iterable<User> findAllByFirstNameNotLike(String like) {
        return userRepository.findAllByFirstNameNotLike(like);
    }
}
