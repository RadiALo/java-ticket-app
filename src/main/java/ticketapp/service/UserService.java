package ticketapp.service;

import java.util.Optional;
import ticketapp.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
