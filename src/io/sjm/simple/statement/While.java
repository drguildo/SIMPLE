package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

public class While implements Expr {
  private Expr cond;
  private Expr exp;

  public While(Expr cond, Expr body) {
    this.cond = cond;
    this.exp = body;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    return new Cond(cond, new Sequence(exp, this), new DoNothing());
  }

  @Override
  public String toString() {
    return String.format("while (%s) { %s }", cond, exp);
  }
}
