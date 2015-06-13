package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

public class DoNothing implements Expr {
  @Override
  public boolean reducible() {
    return false;
  }

  @Override
  public Expr reduce(Environment env) {
    return this;
  }

  @Override
  public DoNothing evaluate(Environment env) {
    return this;
  }

  @Override
  public String toString() {
    return "do-nothing";
  }
}
