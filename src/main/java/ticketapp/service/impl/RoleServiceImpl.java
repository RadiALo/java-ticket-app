package ticketapp.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import ticketapp.model.Role;
import ticketapp.repository.RoleRepository;
import ticketapp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.add(role);
    }

    @Override
    public Role getByName(Role.RoleName roleName) {
        return roleRepository.getByName(roleName).orElseThrow(()
                -> new NoSuchElementException("Can't get role by role name " + roleName));
    }
}
