package web.service;

import web.model.Role;
import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByName(String RoleName);
}