package org.vibioh.spring;

import java.util.logging.Logger;

public interface Process {
  Logger logger = Logger.getLogger(org.vibioh.ioc.Process.class.getSimpleName());

  void execute();

  default Logger getLogger() {
    return logger;
  };
}
