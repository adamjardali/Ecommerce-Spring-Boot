package eg.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eg.com.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
}
