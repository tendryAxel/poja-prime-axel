package com.axel.prime.endpoint.rest.controller;

import com.axel.prime.service.event.PrimeService;
import java.math.BigInteger;
import java.util.List;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Value
public class PrimeGeneratorController {
  PrimeService primeService;

  @GetMapping("/new-prime")
  public BigInteger newPrime() {
    return primeService.generateNewPrime();
  }

  @GetMapping("/genereted-prime")
  public List<BigInteger> generetedPrime() {
    return primeService.getListOfPrime();
  }
}
