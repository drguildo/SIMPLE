package io.sjm.simple;

public interface Expr {
  public boolean reducible();

  public Expr reduce(Environment env);

  public Expr evaluate(Environment env);
}
