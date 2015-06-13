package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;
import io.sjm.simple.type.Bool;

public class Cond implements Expr {
  private Expr cond, cons, alt;

  public Cond(Expr condition, Expr consequence, Expr alternative) {
    this.cond = condition;
    this.cons = consequence;
    this.alt = alternative;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    if (cond.reducible())
      return new Cond(cond.reduce(env), cons, alt);

    if (((Bool) cond).val())
      return cons;

    return alt;
  }

  @Override
  public Expr evaluate(Environment env) {
    if (((Bool) cond).val())
      return cons;

    return alt;
  }

  @Override
  public String toString() {
    return String.format("if (%s) { %s } else { %s }", cond, cons, alt);
  }
}
