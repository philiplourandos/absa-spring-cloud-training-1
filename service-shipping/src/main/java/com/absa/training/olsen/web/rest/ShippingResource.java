package com.absa.training.olsen.web.rest;

import com.absa.training.olsen.service.CourrierService;
import com.absa.training.olsen.service.CustomerFeignClient;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abpl245
 */
@RestController
@RequestMapping(path = "/shipping")
public class ShippingResource {
    
    private final CourrierService courrier;
    private final CustomerFeignClient customerClient;
    
    public ShippingResource(CourrierService courrier, CustomerFeignClient customerClient) {
        this.courrier = courrier;
        this.customerClient = customerClient;
    }
    
    @RequestMapping(path = "/dispatch/{customerId}/{orderId}")
    public ResponseEntity dispatch(@PathVariable("customerId") String customerId, @PathVariable String orderIds) {
        final String shippingAddress = customerClient.getAddress(Long.valueOf(customerId));
        
        final Optional<String> trackingCode = courrier.pickup(orderIds, shippingAddress);
        
        if (trackingCode.isPresent()) {
            return ResponseEntity.ok(trackingCode.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
