package iti.jets.marketplace.servcies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import iti.jets.marketplace.models.Image;
import iti.jets.marketplace.repos.ImageRepo;
import iti.jets.marketplace.repos.ProductRepo;

@Service
public class ImageService {
	@Autowired
	private ImageRepo imageRepo;
	@Autowired
	private ProductRepo productRepo;

	private final String folderPath = "C:/Wekala-images/";


	public String uploadImage (MultipartFile file) throws IOException{
		String filePath = folderPath+file.getOriginalFilename();

		Image image = Image.builder()
		.imageDesc(null)
		.imageUrl(filePath).build();
//********************************product object from client side*********************************
		image.setProduct(productRepo.getProductByproductId(1));
		imageRepo.save(image);

			file.transferTo(new File(filePath));
		
		if(image != null){
			return "image uploaded successfully" + filePath;
		}
		return null;
	}

	// public byte[] downloadImage(int imageId) throws IOException {
    //     Optional<Image> image = imageRepo.findById(imageId);
    //     String filePath=image.get().getImageUrl();
    //     byte[] images = Files.readAllBytes(new File(filePath).toPath());
    //     return images;
    // }
	
}
