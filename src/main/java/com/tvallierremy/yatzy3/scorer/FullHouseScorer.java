package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;
import java.util.Map;

public class FullHouseScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = DiceRollUtil.frequencies(dice);
        return containsPairAndThreeOfKind(frequencies) ? DiceRollUtil.sum(dice) : NO_POINT;
    }

    private boolean containsPairAndThreeOfKind(Map<Integer, Integer> frequencies) {
        return frequencies.containsValue(2) && frequencies.containsValue(3);
    }
}
