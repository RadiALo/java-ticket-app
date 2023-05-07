package ticketapp.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ticketapp.model.User;
import ticketapp.repository.UserRepository;
import ticketapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.get(id).orElseThrow(()
                -> new NoSuchElementException("Can't get user by id " + id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
