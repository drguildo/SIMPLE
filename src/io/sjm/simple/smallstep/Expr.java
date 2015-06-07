package io.sjm.simple.smallstep;

public interface Expr {
  public boolean reducible();

  public Expr reduce(Environment env);
}
