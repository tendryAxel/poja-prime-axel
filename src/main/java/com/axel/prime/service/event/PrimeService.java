package com.axel.prime.service.event;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {
  List<BigInteger> listOfPrime = new ArrayList<>();

  public BigInteger generateNewPrime() {
    BigInteger prime =
        BigInteger.probablePrime(10_000, java.util.concurrent.ThreadLocalRandom.current());
    listOfPrime.add(prime);
    return prime;
  }
  ;

  public List<BigInteger> getListOfPrime() {
    if (listOfPrime.size() < 10) {
      return listOfPrime;
    }
    return listOfPrime.subList(listOfPrime.size() - 10, listOfPrime.size());
  }
  ;
}
