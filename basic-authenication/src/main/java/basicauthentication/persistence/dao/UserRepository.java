package basicauthentication.persistence.dao;

import basicauthentication.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Override
    void delete(User user);
}