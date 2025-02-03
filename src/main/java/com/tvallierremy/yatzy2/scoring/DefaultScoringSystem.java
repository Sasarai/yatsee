package com.tvallierremy.yatzy2.scoring;

import com.tvallierremy.yatzy2.DiceValue;
import com.tvallierremy.yatzy2.YatzyCategory;
import com.tvallierremy.yatzy2.scoring.calculator.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class DefaultScoringSystem extends ScoringSystem {
    private static final int NO_POINT = 0;
    private static final Map<YatzyCategory, ScoreCalculator> SCORE_SYSTEM = new EnumMap<>(Map.ofEntries(
        Map.entry(YatzyCategory.CHANCE, new ChanceScoreCalculator()),
        Map.entry(YatzyCategory.YATZY, new YatzyScoreCalculator()),
        Map.entry(YatzyCategory.ONES, new NumberScoreCalculator(DiceValue.ONE)),
        Map.entry(YatzyCategory.TWOS, new NumberScoreCalculator(DiceValue.TWO)),
        Map.entry(YatzyCategory.THREES, new NumberScoreCalculator(DiceValue.THREE)),
        Map.entry(YatzyCategory.FOURS, new NumberScoreCalculator(DiceValue.FOUR)),
        Map.entry(YatzyCategory.FIVES, new NumberScoreCalculator(DiceValue.FIVE)),
        Map.entry(YatzyCategory.SIXES, new NumberScoreCalculator(DiceValue.SIX)),
        Map.entry(YatzyCategory.PAIR, new MultipleOccurenceScoreCalculator(2)),
        Map.entry(YatzyCategory.TWO_PAIRS, new TwoPairsScoreCalculator()),
        Map.entry(YatzyCategory.THREE_OF_A_KIND, new MultipleOccurenceScoreCalculator(3)),
        Map.entry(YatzyCategory.FOUR_OF_A_KIND, new MultipleOccurenceScoreCalculator(4)),
        Map.entry(YatzyCategory.SMALL_STRAIGHT, new StraightScoreCalculator(StraightScoreCalculator.Strategy.SMALL)),
        Map.entry(YatzyCategory.LARGE_STRAIGHT, new StraightScoreCalculator(StraightScoreCalculator.Strategy.LARGE)),
        Map.entry(YatzyCategory.FULL_HOUSE, new FullHouseScoreCalculator())
    ));

    @Override
    public int evaluate(YatzyCategory category, Map<DiceValue, Long> diceFrequencies) {
        return ofNullable(SCORE_SYSTEM.get(category))
            .map(it -> it.evaluate(diceFrequencies))
            .orElse(NO_POINT);
    }

    @Override
    protected List<String> validCategories() {
        return SCORE_SYSTEM.keySet().stream()
            .map(YatzyCategory::toString)
            .toList();
    }
}
