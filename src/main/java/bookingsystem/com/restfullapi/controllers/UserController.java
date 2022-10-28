package bookingsystem.com.restfullapi.controllers;

import bookingsystem.com.restfullapi.entities.User;
import bookingsystem.com.restfullapi.services.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping(value = "")
    public List<User> getAllUser() {
        return this.userService.userList();
    }

    @GetMapping(value = "/{userId}")
    public Optional<User> getUserBy(@PathVariable("userId") Integer userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping("/save")
    public User saveUser(@Valid @RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") Integer userId) {
        return this.userService.updateUser(user, userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        this.userService.deleteUserById(userId);
    }

}
