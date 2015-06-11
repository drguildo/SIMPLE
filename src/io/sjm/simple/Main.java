package io.sjm.simple;

import io.sjm.simple.op.Add;
import io.sjm.simple.op.LessThan;
import io.sjm.simple.statement.Assign;
import io.sjm.simple.statement.While;
import io.sjm.simple.type.Num;

public class Main {
  public static void main(String[] args) {
    Environment env = new Environment();
    env.put("x", new Num(1));

    Expr exp =
        new While(new LessThan<>(new Variable("x"), new Num(4)), new Assign(new Variable("x"),
            new Add<Expr, Expr>(new Variable("x"), new Num(1))));
    Machine m = new Machine(exp, env);
    m.run();
  }
}
