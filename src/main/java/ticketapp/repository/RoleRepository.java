package ticketapp.repository;

import java.util.Optional;
import ticketapp.model.Role;

public interface RoleRepository {
    Role add(Role role);

    Optional<Role> getByName(Role.RoleName roleName);
}
