package articlemanagementsystem.repositories;

import articlemanagementsystem.model.Role;


public class RoleRepository extends CrudRepository<Role, Long> {
    private static RoleRepository roleRepository;

    private RoleRepository() {}

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    public static RoleRepository getInstance() {
        if (roleRepository == null)
            roleRepository = new RoleRepository();
        return roleRepository;
    }
}
