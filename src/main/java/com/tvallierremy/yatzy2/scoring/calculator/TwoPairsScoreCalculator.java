package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.List;
import java.util.Map;

public record TwoPairsScoreCalculator() implements ScoreCalculator {
    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        List<Integer> pairs = diceFrequencies.entrySet().stream()
            .filter(it -> it.getValue() >= 2)
            .map(it -> it.getKey().getValue() * 2)
            .toList();

        return pairs.size() == 2 ? pairs.stream().reduce(0, Integer::sum) : NO_POINT;
    }
}
