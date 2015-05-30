package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

public class DoNothing implements Expr, Statement {
  @Override
  public boolean reducible() {
    return false;
  }

  @Override
  public Expr reduce(Environment env) {
    return this;
  }

  @Override
  public String toString() {
    return "do-nothing";
  }
}
