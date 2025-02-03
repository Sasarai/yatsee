package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.Map;

import static java.util.Optional.ofNullable;

public record NumberScoreCalculator(DiceValue diceValue) implements ScoreCalculator {
    private static final int NO_POINT = 0;

    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        return ofNullable(diceFrequencies.get(diceValue))
            .map(it -> it.intValue() * diceValue.getValue())
            .orElse(NO_POINT);
    }
}
