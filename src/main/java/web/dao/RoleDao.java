package web.dao;

import web.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRoleById(List<Long> id);
    Set<Role> getRoleById(List<Long> id);
    List<Role> listRoles();
    Role getRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[] roleNames);
}