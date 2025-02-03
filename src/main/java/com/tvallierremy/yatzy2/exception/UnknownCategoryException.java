package com.tvallierremy.yatzy2.exception;

public class UnknownCategoryException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Unknown category: %s";
    public UnknownCategoryException(String category) {
    super(String.format(MESSAGE_FORMAT, category));
  }
}
