package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;
import io.sjm.simple.type.Bool;

public class While implements Expr {
  private Expr cond;
  private Expr body;

  public While(Expr cond, Expr body) {
    this.cond = cond;
    this.body = body;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    return new Cond(cond, new Sequence(body, this), new DoNothing());
  }

  @Override
  public DoNothing evaluate(Environment env) {
    Bool b = (Bool) cond.evaluate(env);

    if (b.val()) {
      body.evaluate(env);
      evaluate(env);
    }

    return new DoNothing();
  }

  @Override
  public String toString() {
    return String.format("while (%s) { %s }", cond, body);
  }
}
