package com.tvallierremy.yatzy2.scoring;


import com.tvallierremy.yatzy2.DiceValue;
import com.tvallierremy.yatzy2.YatzyCategory;
import com.tvallierremy.yatzy2.exception.UnknownCategoryException;
import com.tvallierremy.yatzy2.utils.DiceUtils;

import java.util.List;
import java.util.Map;

public abstract class ScoringSystem {
    protected abstract int evaluate(YatzyCategory category, Map<DiceValue, Long> diceFrequencies);
    protected abstract List<String> validCategories();

    public int evaluate(String category, List<Integer> dices) {
        return evaluate(getCategory(category), DiceUtils.getDiceFrequencies(dices));
    }

    private YatzyCategory getCategory(String category) {
        validateCategory(category);
        return YatzyCategory.valueOf(category);
    }

    private void validateCategory(String category) {
        if (!validCategories().contains(category)) {
            throw new UnknownCategoryException(category);
        }
    }

}
