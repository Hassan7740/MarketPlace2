package iti.jets.marketplace.repos;

import iti.jets.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User getUserByEmail(String email);

}
