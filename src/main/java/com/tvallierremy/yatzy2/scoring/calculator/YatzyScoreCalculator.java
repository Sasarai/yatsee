package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.Map;

public record YatzyScoreCalculator() implements ScoreCalculator {
    private static final Integer YATZY_SCORE = 50;
    private static final Integer NO_POINT = 0;
    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        return diceFrequencies.containsValue(5L) ? YATZY_SCORE : NO_POINT;
    }
}
