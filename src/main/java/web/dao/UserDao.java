package web.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}
