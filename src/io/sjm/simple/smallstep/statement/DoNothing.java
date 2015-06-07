package io.sjm.simple.smallstep.statement;

import io.sjm.simple.smallstep.Environment;
import io.sjm.simple.smallstep.Expr;

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
  public String toString() {
    return "do-nothing";
  }
}
