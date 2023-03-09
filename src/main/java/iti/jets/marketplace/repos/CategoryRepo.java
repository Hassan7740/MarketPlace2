package iti.jets.marketplace.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
   
}
