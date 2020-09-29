package hsadminbackapp.demo.jpa;

import hsadminbackapp.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User getUserByUsername(String name);

}
