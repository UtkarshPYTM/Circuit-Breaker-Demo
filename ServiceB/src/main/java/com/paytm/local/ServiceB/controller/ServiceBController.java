package com.paytm.local.ServiceB.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class ServiceBController {

  @GetMapping
  public ResponseEntity<String> serviceB() {
//        throw new BusinessException("Logical error!");
//        return ResponseEntity.status(404).body("Not Found Error!");
    return ResponseEntity.ok("Response from service B, called from Service A");
  }

}
