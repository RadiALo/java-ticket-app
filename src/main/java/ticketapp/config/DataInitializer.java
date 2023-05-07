package ticketapp.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ticketapp.model.Role;
import ticketapp.model.User;
import ticketapp.service.AuthenticationService;
import ticketapp.service.RoleService;
import ticketapp.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authService;

    public DataInitializer(RoleService roleService, UserService userService,
                           AuthenticationService authService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authService = authService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        User admin = new User();
        admin.setEmail("admin@i.ua");
        admin.setPassword("admin123");
        admin.setRoles(Set.of(adminRole, userRole));
        userService.add(admin);

        authService.register("alice@i.ua", "alice123");
    }
}
