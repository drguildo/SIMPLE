package io.sjm.simple.smallstep.op;

import io.sjm.simple.smallstep.Environment;
import io.sjm.simple.smallstep.Expr;
import io.sjm.simple.smallstep.type.Bool;
import io.sjm.simple.smallstep.type.Num;

public class LessThan<TL extends Expr, TR extends Expr> implements Expr {
  private TL left;
  private TR right;

  public LessThan(TL left, TR right) {
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
      return new LessThan<>(left.reduce(env), right);
    else if (right.reducible())
      return new LessThan<>(left, right.reduce(env));
    else {
      if (((Num) left).val() < ((Num) right).val())
        return new Bool(true);
      return new Bool(false);
    }
  }

  @Override
  public String toString() {
    return String.format("%s < %s", left, right);
  }
}
