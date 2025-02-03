package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;

public class YatzyPointsScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        if (DiceRollUtil.frequencies(dice).containsValue(5)) {
            return 50;
        }
        return NO_POINT;
    }
}
