package com.devisv.practice.online.core.convertor;

import java.util.Objects;

public class ConverterId {

  private Class input;

  private Class output;

  public ConverterId(Class input, Class output) {
    this.input = input;
    this.output = output;
  }

  public Class getInput() {
    return input;
  }

  public Class getOutput() {
    return output;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConverterId)) {
      return false;
    }
    ConverterId that = (ConverterId) o;
    return Objects.equals(input, that.input) && Objects.equals(output, that.output);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output);
  }
}
