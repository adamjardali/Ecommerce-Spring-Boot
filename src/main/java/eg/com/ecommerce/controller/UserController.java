package eg.com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import eg.com.ecommerce.dto.UserDto;
import eg.com.ecommerce.model.User;
import eg.com.ecommerce.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = { "", "/" })
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        User user = new User();
        user.setId(id);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        // Set other user properties as needed

        return userService.updateUser(user);
    }
}
