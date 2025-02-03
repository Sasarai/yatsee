package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;
import com.tvallierremy.yatzy2.utils.DiceUtils;

import java.util.Map;

public record FullHouseScoreCalculator() implements ScoreCalculator {
    private static final Integer PAIR_OCCURRENCE = 2;
    private static final Integer THREE_OF_KIND_OCCURRENCE = 3;

    @Override
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        return containsPairAndThreeOfKind(diceFrequencies) ? DiceUtils.diceRollSum(diceFrequencies) : NO_POINT;
    }

    private boolean containsPairAndThreeOfKind(Map<DiceValue, Long> diceFrequencies) {
        return diceFrequencies.containsValue(PAIR_OCCURRENCE.longValue()) && diceFrequencies.containsValue(THREE_OF_KIND_OCCURRENCE.longValue());
    }
}
