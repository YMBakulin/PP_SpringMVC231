package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager em;

//    @Override
//    public void createUserTable() {
//        String sql = "CREATE TABLE IF NOT EXIST `db_pp231`.`users` (\n" +
//                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                "  `name` VARCHAR(45) NULL,\n" +
//                "  `surname` VARCHAR(45) NOT NULL,\n" +
//                "  `age` TINYINT(3) NULL,\n" +
//                "  `email` VARCHAR(45) NULL,\n" +
//                "  PRIMARY KEY (`id`));";
//    }

    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        User user = getUserById(id);
        em.remove(user);
        em.flush();
        em.clear();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

}
