package com.lottoland.rockscissorpaper.domain;

public enum Choice {
  ROCK("Rock",0),
  SCISSORS("Scissors",2),
  PAPER("Paper",1);

  private String uniqueName;
  private int value;

  public String getUniqueName() {
    return uniqueName;
  }

  public int getValue() {
    return value;
  }

  private Choice(String uniqueName,int value) {
    this.uniqueName = uniqueName;
    this.value = value;
  }
}
