package br.senai.lab365.fshealth.pokedex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApplication {
  private static final Logger LOGGER = LogManager.getLogger(PokedexApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(PokedexApplication.class, args);

    LOGGER.debug("nivel debug");
    LOGGER.info("nivel INFO");
    LOGGER.warn("nivel WARN");
  }
}
