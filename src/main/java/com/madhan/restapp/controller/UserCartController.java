package com.madhan.restapp.controller;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.UserCart;
import com.madhan.restapp.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/userCart")
public class UserCartController {

    @Autowired
    private UserCartService userCartService;

    @PostMapping("/insertUserCart")
    public ResponseEntity<String> createUserCart(@RequestBody UserCart userCart) {
        try {
            userCartService.saveUserCart(userCart);
            return ResponseEntity.ok("User cart created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Creation Failure: " + e.getMessage());
        }
    }

    @PostMapping("/addItem/{cartId}")
    public ResponseEntity<UserCart> addItemToCart(@PathVariable Long cartId, @RequestBody CartItem newItem) {
        try {
            UserCart updatedCart = userCartService.addItemToCart(cartId, newItem);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deleteUserCart/{id}")
    public ResponseEntity<String> deleteUserCart(@PathVariable Long id) {
        try {
            userCartService.deleteUserCart(id);
            return ResponseEntity.ok("User cart deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Deletion Failure: " + e.getMessage());
        }
    }

    @GetMapping("/findUserCartById/{id}")
    public ResponseEntity<UserCart> getUserCartById(@PathVariable Long id) {
        try {
            UserCart userCart = userCartService.getUserCartById(id);
            return ResponseEntity.ok(userCart);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAllUserCarts")
    public ResponseEntity<List<UserCart>> getAllUserCarts() {
        try {
            List<UserCart> userCarts = userCartService.getAllUserCarts();
            return ResponseEntity.ok(userCarts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
