package com.absa.training.olsen.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author abpl245
 */
@FeignClient("customer-service")
public interface CustomerFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/customer/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    String getAddress(@PathVariable("${customerId}") Long customerId);
}
