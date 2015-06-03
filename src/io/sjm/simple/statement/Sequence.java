package io.sjm.simple.statement;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

public class Sequence implements Expr {
  private Expr first;
  private Expr second;

  public Sequence(Expr first, Expr second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    if (first.reducible())
      return new Sequence(first.reduce(env), second);

    return second;
  }

  @Override
  public String toString() {
    return String.format("%s; %s", first, second);
  }
}
