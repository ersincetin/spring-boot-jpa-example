package bookingsystem.com.restfullapi.services.concretes;

import bookingsystem.com.restfullapi.repositories.UserRepository;
import bookingsystem.com.restfullapi.entities.User;
import bookingsystem.com.restfullapi.services.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<User> userList() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Integer id) {
        User userDB = userRepository.findById(id).get();

        userDB.setUsername(user.getUsername());
        userDB.setEmail(user.getEmail());
        userDB.setFirstname(user.getFirstname());
        userDB.setLastname(user.getLastname());
        userDB.setStatus(user.getStatus());
        userDB.setType(user.getType());
        userDB.setRole(user.getRole());

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }
}
