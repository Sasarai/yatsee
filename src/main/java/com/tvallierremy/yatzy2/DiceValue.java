package com.tvallierremy.yatzy2;

import com.tvallierremy.yatzy2.exception.DiceValueNotFound;

import java.util.Arrays;

public enum DiceValue {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    DiceValue(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        return value;
    }

    public static DiceValue getFromValue(Integer value) {
        return Arrays.stream(DiceValue.values()).filter(it -> it.value == value)
            .findFirst()
            .orElseThrow(() -> new DiceValueNotFound(value));
    }
}
