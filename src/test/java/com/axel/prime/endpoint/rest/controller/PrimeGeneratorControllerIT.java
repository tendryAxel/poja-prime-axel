package com.axel.prime.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.axel.prime.conf.FacadeIT;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PrimeGeneratorControllerIT extends FacadeIT {

  @Autowired PrimeGeneratorController primeGeneratorController;

  @Test
  void newPrime() {
    assertTrue(primeGeneratorController.newPrime().isProbablePrime(90));
  }

  @Test
  void store_one_prime() {
    BigInteger prime = primeGeneratorController.newPrime();
    List<BigInteger> listPrime = primeGeneratorController.generetedPrime();
    assertEquals(prime, listPrime.get(listPrime.size() - 1));
  }

  @Test
  void store_two_prime() {
    BigInteger prime1 = primeGeneratorController.newPrime();
    BigInteger prime2 = primeGeneratorController.newPrime();
    List<BigInteger> listPrime = primeGeneratorController.generetedPrime();
    assertEquals(prime2, listPrime.get(listPrime.size() - 1));
    assertEquals(prime1, listPrime.get(listPrime.size() - 2));
  }
}
