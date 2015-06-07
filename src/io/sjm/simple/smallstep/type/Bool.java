package io.sjm.simple.smallstep.type;

public class Bool extends Value<Boolean> {
  public Bool(Boolean value) {
    super(value);
  }

  @Override
  public boolean reducible() {
    return false;
  }
}
