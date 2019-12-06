package ua.od.atomspace.Twitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.Twitter.dao.models.User;
import ua.od.atomspace.Twitter.dao.repos.UserRepository;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
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
        userRepository.save(user);
        return null;
    }
}
