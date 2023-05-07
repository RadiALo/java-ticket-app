package ticketapp.service;

import ticketapp.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(Role.RoleName roleName);
}
