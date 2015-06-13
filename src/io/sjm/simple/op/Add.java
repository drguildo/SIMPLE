package io.sjm.simple.op;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;
import io.sjm.simple.type.Num;

public class Add<TL extends Expr, TR extends Expr> implements Expr {
  private TL left;
  private TR right;

  public Add(TL left, TR right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    if (left.reducible())
      return new Add<>(left.reduce(env), right);
    else if (right.reducible())
      return new Add<>(left, right.reduce(env));
    else {
      Num nl = (Num) left;
      Num nr = (Num) right;
      return new Num(nl.val() + nr.val());
    }
  }

  @Override
  public Num evaluate(Environment env) {
    Num nl = (Num) left.evaluate(env);
    Num nr = (Num) right.evaluate(env);
    return new Num(nl.val() + nr.val());
  }

  @Override
  public String toString() {
    return String.format("%s + %s", left, right);
  }
}
