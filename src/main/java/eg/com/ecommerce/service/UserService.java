package eg.com.ecommerce.service;

import java.util.List;

import eg.com.ecommerce.dto.UserDto;
import eg.com.ecommerce.model.User;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    User updateUser(User user);
}
