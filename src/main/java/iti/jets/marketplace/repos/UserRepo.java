package iti.jets.marketplace.repos;

import iti.jets.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User getUserByEmail(String email);

    public Optional<User> findByEmail(String email);

}
