package com.lottoland.rockscissorpaper.domain.exception;

public class InvalidConditionsException extends RuntimeException {

  public InvalidConditionsException() {
    super();
  }

  public InvalidConditionsException(String msg) {
    super();
  }

  protected InvalidConditionsException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
