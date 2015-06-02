package io.sjm.simple.type;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

public enum Bool implements Expr {
  TRUE, FALSE;

  @Override
  public boolean reducible() {
    return false;
  }

  @Override
  public Expr reduce(Environment env) {
    return Bool.values()[this.ordinal()];
  }
}
