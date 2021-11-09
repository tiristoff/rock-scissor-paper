package com.lottoland.rockscissorpaper.domain;

import com.lottoland.rockscissorpaper.domain.exception.InvalidConditionsException;

import java.util.Arrays;

public enum Result {
  WIN("WIN", 2,"LOST"),
  DRAW("DRAW", 1,"DRAW"),
  LOST("LOST", 0,"WIN");

  private String uniqueName;
  private int value;
  private String oppositeResult;

  public int getValue() {
    return value;
  }

  public String getUniqueName() {
    return uniqueName;
  }

  public String getOppositeResult() {
    return oppositeResult;
  }

  private Result(String uniqueName, int value, String oppositeResult) {
    this.uniqueName = uniqueName;
    this.value = value;
    this.oppositeResult = oppositeResult;
  }

  public static Result getByValue(int value) {
    return Arrays.stream(Result.values())
        .filter(r -> r.getValue() == value)
        .findFirst()
        .orElseThrow(() -> new InvalidConditionsException("Result value out of range"));
  }


}
