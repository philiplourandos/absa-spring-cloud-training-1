package com.absa.training.olsen.service;

import java.util.Optional;

/**
 *
 * @author abpl245
 */
public interface CourrierService {
    Optional<String> pickup(final String orderId, final String address);
}
