package eg.com.ecommerce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.com.ecommerce.dto.UserDto;
import eg.com.ecommerce.exception.ResourceNotFoundException;
import eg.com.ecommerce.model.User;
import eg.com.ecommerce.repository.UserRepository;
import eg.com.ecommerce.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        logger.info("Get all users");
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        // You can perform additional validation or logic here if needed
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Update the fields of the existing user with the new values
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());

        // You can update other fields as needed

        return userRepository.save(existingUser);
    }
}
