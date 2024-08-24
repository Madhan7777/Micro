package com.madhan.restapp.controller;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-tracking")
@CrossOrigin("*")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService orderTrackingService;

    @PostMapping
    public ResponseEntity<OrderTracking> createOrderTracking(@RequestBody OrderTracking orderTracking) {
        OrderTracking savedOrderTracking = orderTrackingService.save(orderTracking);
        return ResponseEntity.ok(savedOrderTracking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderTracking> getOrderTrackingById(@PathVariable Long id) {
        Optional<OrderTracking> orderTracking = orderTrackingService.findById(id);
        return orderTracking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderTracking>> getAllOrderTrackings() {
        List<OrderTracking> orderTrackings = orderTrackingService.findAll();
        return ResponseEntity.ok(orderTrackings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderTracking> updateOrderTrackingStatus(
            @PathVariable Long id, @RequestBody OrderTracking orderTracking) {
        Optional<OrderTracking> existingOrderTrackingOpt = orderTrackingService.findById(id);
        
        if (existingOrderTrackingOpt.isPresent()) {
            OrderTracking existingOrderTracking = existingOrderTrackingOpt.get();
            
            existingOrderTracking.setStatus(orderTracking.getStatus());
            
            OrderTracking updatedOrderTracking = orderTrackingService.save(existingOrderTracking);
            
            return ResponseEntity.ok(updatedOrderTracking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderTracking(@PathVariable Long id) {
        orderTrackingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
