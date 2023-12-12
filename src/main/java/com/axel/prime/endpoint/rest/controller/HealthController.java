package com.axel.prime.endpoint.rest.controller;

import static java.util.UUID.randomUUID;

import com.axel.prime.PojaGenerated;
import com.axel.prime.endpoint.event.EventProducer;
import com.axel.prime.endpoint.event.gen.UuidCreated;
import com.axel.prime.repository.DummyRepository;
import com.axel.prime.repository.DummyUuidRepository;
import com.axel.prime.repository.model.Dummy;
import com.axel.prime.repository.model.DummyUuid;
import java.util.List;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@Value
public class HealthController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;
  EventProducer eventProducer;

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/dummy-table")
  public List<Dummy> dummyTable() {
    return dummyRepository.findAll();
  }

  @GetMapping(value = "/uuid-created")
  public String uuidCreated() throws InterruptedException {
    var randomUuid = randomUUID().toString();
    var event = new UuidCreated().toBuilder().uuid(randomUuid).build();

    eventProducer.accept(List.of(event));

    Thread.sleep(20_000);
    return dummyUuidRepository.findById(randomUuid).map(DummyUuid::getId).orElseThrow();
  }
}
