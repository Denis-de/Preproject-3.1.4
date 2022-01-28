package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRoleById(List<Long> id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public Set<Role> getRoleById(List<Long> id) {
        TypedQuery<Role> query = entityManager.createQuery("select u from Role u where u.id in :id", Role.class);
        return new HashSet<>(query.setParameter("id", id).getResultList());
    }

    @Override
    public List<Role> listRoles() {
        TypedQuery<Role> query=entityManager.createQuery("select distinct u FROM Role u LEFT JOIN FETCH u.users", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        Query query = entityManager.createQuery("select distinct u from Role u LEFT JOIN FETCH u.users where u.name =: name");
        query.setParameter("name", name);
        Role role = (Role) query.getSingleResult();
        return entityManager.find(Role.class, role.getId());
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet) roleSet;
    }
}