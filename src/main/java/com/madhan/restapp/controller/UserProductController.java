package com.madhan.restapp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.madhan.restapp.model.UserProduct;
import com.madhan.restapp.service.UserProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/UserProduct")
public class UserProductController {
	
	@Autowired
	UserProductService service;
	
	@PostMapping(value="/insertSellerProduct",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertProduct(@RequestParam ("productName") String productName,
		@RequestParam("imageProduct") MultipartFile file,
        @RequestParam("description") String description,
        @RequestParam("price") int price,
      
        @RequestParam("category") String category,
        @RequestParam("quantity") String quantity) throws IOException {

		UserProduct img = new UserProduct();
    img.setProductName(productName);
    img.setDescription(description);
    img.setQuantity(quantity);
    img.setPrice(price);
    img.setCategory(category);
   
    img.setImageName(file.getOriginalFilename());
    img.setImageType(file.getContentType());
    img.setImageProduct(Base64.getEncoder().encode(file.getBytes()));

    try {
        service.insertProduct(img);
        return ResponseEntity.ok("details inserted successfully");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Deletion Failure");
    }
	}
	
	@GetMapping("/findProdImage/{id}")
	public ResponseEntity<ByteArrayResource> find(@PathVariable ("id") Long productId) {
		try {
			UserProduct product = service.findProductyById(productId);
			byte[] imageProduct = Base64.getDecoder().decode(product.getImageProduct());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(product.getImageType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + product.getImageName() + "\"")
					.body(new ByteArrayResource(imageProduct));
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/updateSellerProduct")
	public ResponseEntity<String> updateProduct(@RequestBody UserProduct Product){
		try{
			service.updateProduct(Product);
			return ResponseEntity.ok("product updated successfully");
		}catch(Exception e){
			return ResponseEntity.badRequest().body("Updation Failure");
		}
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId")Long productId){
		try {
			service.deleteProduct(productId);
			return ResponseEntity.ok("Deletion Success");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
		@GetMapping("/findProductById/{productId}")
		public UserProduct doFindBySellerProduct(@PathVariable("productId")Long productId) {
			return service.findProductyById(productId);
		}

	@GetMapping("/findAllProduct")
	public List<UserProduct> findAllProduct() {
		return service.findAllProduct();
	}


}
