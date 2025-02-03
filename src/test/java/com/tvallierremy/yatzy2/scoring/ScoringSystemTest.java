package com.tvallierremy.yatzy2.scoring;

import com.tvallierremy.yatzy2.DiceValue;
import com.tvallierremy.yatzy2.YatzyCategory;
import com.tvallierremy.yatzy2.exception.UnknownCategoryException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.tvallierremy.yatzy2.YatzyCategory.CHANCE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoringSystemTest {
    @Test
    void shouldThrowsExceptionWhenCategoryIsNotSupportedByScoringSystem() {
        ScoringSystem scoringSystem = new EmptyScoringSystem();
        String category = CHANCE.name();
        List<Integer> dices = asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> scoringSystem.evaluate(category, dices))
            .isInstanceOf(UnknownCategoryException.class);
    }

    private static class EmptyScoringSystem extends ScoringSystem {
        @Override
        protected int evaluate(YatzyCategory category, Map<DiceValue, Long> diceFrequencies) {
            return 0;
        }

        @Override
        protected List<String> validCategories() {
            return List.of();
        }
    }
}
