package com.tvallierremy.yatzy2.scoring.calculator;

import com.tvallierremy.yatzy2.DiceValue;
import com.tvallierremy.yatzy2.utils.DiceUtils;

import java.util.Map;

public record ChanceScoreCalculator() implements ScoreCalculator {
    public int evaluate(Map<DiceValue, Long> diceFrequencies) {
        return DiceUtils.diceRollSum(diceFrequencies);
    }
}
