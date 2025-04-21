package io.github.juniperfags.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BearerToken {

  private BearerToken() {}

  private static final Logger logger = LoggerFactory.getLogger(BearerToken.class);

  public static boolean hasBearerToken(String token) {

    logger.info("Checking if the provided token exists ...");

    if (token == null) {
      return false;
    }

    return token.startsWith("Bearer ");
  }

}
