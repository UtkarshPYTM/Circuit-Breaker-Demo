package com.paytm.local.ServiceA.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/a")
public class ServiceAController {

  private static final String BASE_URL
      = "http://localhost:8081/";
  private static final String SERVICE_A = "serviceA";
  int count = 1;
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
  public String serviceA(@RequestParam("name") String name) {
    String url = BASE_URL + "b";
    return restTemplate.getForObject(
        url,
        String.class
    );
  }

  public String serviceAFallback(String name, Exception e) {
    return "This is a fallback method for Service A for name: " + name;
  }
}
