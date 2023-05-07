package ticketapp.repository.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ticketapp.exception.DataProcessingException;
import ticketapp.model.Role;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {
    public RoleRepositoryImpl(SessionFactory factory, Class<Role> clazz) {
        super(factory, clazz);
    }

    @Override
    public Optional<Role> getByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getByRoleName = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            getByRoleName.setParameter("roleName", roleName);
            return getByRoleName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Role by name " + roleName, e);
        }
    }
}
