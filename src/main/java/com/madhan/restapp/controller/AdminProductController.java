package com.madhan.restapp.controller;



import java.io.IOException;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import org.springframework.core.io.Resource; // For handling file resources
import org.springframework.http.HttpHeaders; // For HTTP headers
import org.springframework.http.HttpStatus; // For HTTP status codes
import org.springframework.http.ResponseEntity; // For constructing the HTTP response
import org.springframework.web.bind.annotation.GetMapping; // For mapping HTTP GET requests
import org.springframework.web.bind.annotation.RequestMapping; // For mapping request paths
import org.springframework.web.bind.annotation.RestController; // For defining REST controllers
import org.springframework.core.io.ClassPathResource; // For loading files from the classpath

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.service.AdminProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/AdminProduct")
public class AdminProductController {
	
	@Autowired
	AdminProductService service;
	
	@PostMapping(value="/insertSellerProduct",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertProduct(@RequestParam ("productName") String productName,
		@RequestParam("imageProduct") MultipartFile file,
        @RequestParam("description") String description,
        @RequestParam("price") int price,
      
        @RequestParam("category") String category,
        @RequestParam("quantity") String quantity) throws IOException {

		AdminProduct img = new AdminProduct();
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
			AdminProduct product = service.findProductyById(productId);
			byte[] imageProduct = Base64.getDecoder().decode(product.getImageProduct());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(product.getImageType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + product.getImageName() + "\"")
					.body(new ByteArrayResource(imageProduct));
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/updateSellerProduct")
	public ResponseEntity<String> updateProduct(
	        @RequestParam("productId") Long productId,
	        @RequestParam("productName") String productName,
	        @RequestParam("description") String description,
	        @RequestParam("price") int price,
	        @RequestParam("category") String category,
	        @RequestParam("quantity") String quantity,
	        @RequestParam(value = "imageProduct", required = false) MultipartFile imageProduct) {

	    try {
	        AdminProduct product = service.findProductyById(productId);
	        if (product != null) {
	            product.setProductName(productName);
	            product.setDescription(description);
	            product.setPrice(price);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            if (imageProduct != null) {
	                product.setImageName(imageProduct.getOriginalFilename());
	                product.setImageType(imageProduct.getContentType());
	                product.setImageProduct(Base64.getEncoder().encode(imageProduct.getBytes()));
	            }
	            service.updateProduct(product);
	            return ResponseEntity.ok("Product updated successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Product not found");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Log the exception for debugging
	        return ResponseEntity.badRequest().body("Failed to update product");
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
		public AdminProduct doFindBySellerProduct(@PathVariable("productId")Long productId) {
			return service.findProductyById(productId);
		}

	@GetMapping("/findAllProduct")
	public List<AdminProduct> findAllProduct() {
		return service.findAllProduct();
	}


}
