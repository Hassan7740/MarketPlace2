package iti.jets.marketplace.repos;

import iti.jets.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

<<<<<<< HEAD
=======

>>>>>>> b6566a6ca6dbbd705b7a0a4e424a75b306cc5d8e
    public User getUserByEmail(String email);

}
