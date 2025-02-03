package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.Map;

@FunctionalInterface
public interface ScoreCalculator {
    int evaluate(Map<DiceValue, Long> diceFrequencies);
}
