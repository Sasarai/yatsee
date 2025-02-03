package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public record StraightScoreCalculator(Strategy strategy) implements ScoreCalculator {
    private static final Integer NO_POINT = 0;

    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        Set<Integer> obtainedValues = diceFrequencies.entrySet().stream()
            .filter(it -> it.getValue() != 0)
            .map(it -> it.getKey().getValue())
            .collect(Collectors.toSet());

        return obtainedValues.containsAll(strategy.getNeededContent()) ? obtainedValues.stream().reduce(0, Integer::sum) : NO_POINT;
    }

    public enum Strategy {
        SMALL (asList(1, 2, 3, 4, 5)),
        LARGE(asList(2, 3, 4, 5, 6));

        private final List<Integer> neededContent;

        Strategy(List<Integer> neededContent) {
            this.neededContent = neededContent;
        }

        public List<Integer> getNeededContent() {
            return neededContent;
        }
    }
}
