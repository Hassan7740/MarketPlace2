package iti.jets.marketplace.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import iti.jets.marketplace.dtos.ImageDTO;
import iti.jets.marketplace.models.Image;
import iti.jets.marketplace.servcies.ImageService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private ImageService imageService;

	@PostMapping("/upload")
	public ResponseViewModel<Object> uploadImage(@RequestParam("image")MultipartFile image)throws IOException{
		imageService.uploadImage(image);
		return ResponseViewModel.<Object>builder().data(null).message("image added successfully").statusCode(HttpStatus.OK.value()).build();
	}

	// @GetMapping("/{imageId}")
	// public ResponseEntity<byte[]> downloadImage(@PathVariable int imageId)throws IOException{
	// 	return ResponseEntity.ok(imageService.downloadImage(imageId));
	// }
}
