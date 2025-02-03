package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.Comparator;
import java.util.Map;

public record MultipleOccurenceScoreCalculator(Integer wantedOccurrence) implements ScoreCalculator {
    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        return diceFrequencies.entrySet().stream()
            .filter(it -> it.getValue() >= wantedOccurrence)
            .max(Comparator.comparingInt(a -> a.getKey().getValue()))
            .map(it -> it.getKey().getValue() * wantedOccurrence)
            .orElse(NO_POINT);
    }
}
