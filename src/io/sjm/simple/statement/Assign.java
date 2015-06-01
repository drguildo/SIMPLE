package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;
import io.sjm.simple.Variable;
import io.sjm.simple.type.Value;

public class Assign implements Expr {
  private Variable var;
  private Expr expr;

  public Assign(Variable var, Expr expr) {
    this.var = var;
    this.expr = expr;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    if (expr.reducible())
      return new Assign(var, expr.reduce(env));

    env.put(var.getName(), (Value<?>) expr);

    return new DoNothing();
  }

  @Override
  public String toString() {
    return String.format("«%s = %s»", var, expr);
  }
}
