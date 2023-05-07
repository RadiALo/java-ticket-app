package ticketapp.service.impl;

import ticketapp.model.Role;
import ticketapp.model.User;
import ticketapp.service.AuthenticationService;
import ticketapp.service.RoleService;
import ticketapp.service.ShoppingCartService;
import ticketapp.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getByName(Role.RoleName.USER)));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}