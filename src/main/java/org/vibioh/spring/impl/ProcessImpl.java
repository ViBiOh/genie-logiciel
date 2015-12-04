package org.vibioh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vibioh.ioc.Operation;
import org.vibioh.ioc.Reader;
import org.vibioh.ioc.Writer;
import org.vibioh.spring.Process;

import java.io.IOException;
import java.util.logging.Level;

@Component
public class ProcessImpl<I> implements Process {

  @Autowired
  private Reader<I> reader;
  @Autowired
  private Operation<I, Object> operation;
  @Autowired
  private Writer<Object> writer;

  @Override
  public int execute() {
    try {
      writer.write(operation.compute(reader.read()));
      return 0;
    } catch (final IOException e) {
      getLogger().log(Level.SEVERE, "Something went wrong", e);
      return 1;
    }
  }
}
