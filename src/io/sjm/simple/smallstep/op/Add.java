package io.sjm.simple.smallstep.op;

import io.sjm.simple.smallstep.Environment;
import io.sjm.simple.smallstep.Expr;
import io.sjm.simple.smallstep.type.Num;

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
    else
      return new Num(((Num) left).val() + ((Num) right).val());
  }

  @Override
  public String toString() {
    return String.format("%s + %s", left, right);
  }
}
