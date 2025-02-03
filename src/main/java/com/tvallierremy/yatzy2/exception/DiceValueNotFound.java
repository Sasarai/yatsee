package com.tvallierremy.yatzy2.exception;

public class DiceValueNotFound extends RuntimeException {
    private static final String MESSAGE_FORMAT = "The dice value '%s' was not found.";

    public DiceValueNotFound(int value) {
        super(String.format(MESSAGE_FORMAT, value));
    }
}
