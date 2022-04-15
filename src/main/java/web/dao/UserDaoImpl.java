package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers(Integer count) {
        List<User> list = entityManager.createQuery("from User", User.class).getResultList();
        if (count != null && count <= list.size() && count >= 0) {
            return list.stream().limit(count).collect(Collectors.toList());
        }
        return list;
    }
}
