package iti.jets.marketplace.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Image;

public interface ImageRepo extends JpaRepository<Image,Integer> {

	Optional<Image> findById(int imageId);
	
}
