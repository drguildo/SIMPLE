package io.sjm.simple;

public class Variable implements Expr {
  private String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public boolean reducible() {
    return true;
  }

  @Override
  public Expr reduce(Environment env) {
    return env.get(getName());
  }

  @Override
  public Expr evaluate(Environment env) {
    return env.get(getName());
  }

  @Override
  public String toString() {
    return getName();
  }

  public String getName() {
    return name;
  }
}
