package io.sjm.simple;

import io.sjm.stdlib.IO;

public final class Machine {
  private Environment env;
  private Expr state;

  public Machine(Expr state, Environment env) {
    IO.prnl("Welcome my son. Welcome to the machine.");

    this.env = env;
    this.state = state;
  }

  public Expr step() {
    state = state.reduce(env);
    return state;
  }

  public void run() {
    while (state.reducible()) {
      IO.prnl(String.format("|%s| |%s|", state, env));
      step();
    }
    IO.prnl(String.format("|%s| |%s|", state, env));
  }
}
