package ticketapp.service;

import ticketapp.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
