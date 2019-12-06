package ua.od.atomspace.Twitter.services;

import ua.od.atomspace.Twitter.dao.models.User;
import ua.od.atomspace.Twitter.services.exceptions.ObjectNotFoundException;

public interface UserService {

    User delete(Long id) throws ObjectNotFoundException;

    Iterable<User> findAll();

    User save(User user);
}
