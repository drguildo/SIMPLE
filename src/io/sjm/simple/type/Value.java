package io.sjm.simple.type;

import io.sjm.simple.Environment;
import io.sjm.simple.Expr;

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
