package com.absa.training.olsen.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author abpl245
 */
@Service
public class AmaraxCourrierService implements CourrierService {

    @Override
    public Optional<String> pickup(String orderId, String address) {
        return Optional.of(UUID.randomUUID().toString());
    }
}
