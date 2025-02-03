package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;

public class ChanceScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        return DiceRollUtil.sum(dice);
    }
}
