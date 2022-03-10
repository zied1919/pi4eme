package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("select u.mail from User u where u.id=:id ")
    String mail(@Param("id") Long id);
}
