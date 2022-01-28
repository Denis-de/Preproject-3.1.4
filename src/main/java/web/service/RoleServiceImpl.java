package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(List<Long> id) {
        roleDao.deleteRoleById(id);
    }

    @Override
    @Transactional
    public Set<Role> getRoleById(List<Long> id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        return roleDao.getSetOfRoles(roleNames);
    }
}