package ticketapp.repository;

import java.util.Optional;
import ticketapp.model.User;

public interface UserRepository {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
