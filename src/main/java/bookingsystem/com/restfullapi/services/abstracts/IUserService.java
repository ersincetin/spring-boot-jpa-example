package bookingsystem.com.restfullapi.services.abstracts;

import bookingsystem.com.restfullapi.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> getUser(Integer id);

    List<User> userList();

    User updateUser(User user, Integer id);

    void deleteUserById(Integer id);
}
