package io.sjm.simple.smallstep.type;

import io.sjm.simple.smallstep.Environment;
import io.sjm.simple.smallstep.Expr;

public abstract class Value<T> implements Expr {
  protected T value;

  public Value(T value) {
    this.value = value;
  }

  @Override
  public boolean reducible() {
    return false;
  }

  @Override
  public Value<T> reduce(Environment env) {
    return this;
  }

  public T val() {
    return value;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
