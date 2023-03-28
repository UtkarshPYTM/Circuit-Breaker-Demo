package com.paytm.local.ServiceA.controller;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class StateTransitionController {
  @Autowired private CircuitBreakerRegistry circuitBreakerRegistry;

  @GetMapping("/transition-to-half-open")
  public String transitionToHalfOpen() {
    CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("serviceA");
    circuitBreaker.transitionToHalfOpenState();
    return "Circuit breaker state: " + circuitBreaker.getState();
  }
}
