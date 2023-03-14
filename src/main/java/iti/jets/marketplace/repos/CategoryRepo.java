package iti.jets.marketplace.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Category;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepo extends JpaRepository<Category,Integer>{

    @Query("SELECT c FROM Category c")
    public List<Category> findAll();
   
}
