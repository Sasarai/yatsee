package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;

public class NumberScorer extends CategoryScorer {
    private final int number;

    public NumberScorer(int number) {
        this.number = number;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return DiceRollUtil.frequencies(dice).get(number) * number;
    }
}
