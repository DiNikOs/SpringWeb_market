package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.persist.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u join fetch u.roles r where u.userName = :userName")
    User findOneByUserName(String userName);

    Optional<User> findUserByUsername(String userName);

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
