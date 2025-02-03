package com.tvallierremy.yatzy2.utils;

import com.tvallierremy.yatzy2.DiceValue;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class DiceUtilsTest {
    private final Map<DiceValue, Long> frequencies = Map.of(
        DiceValue.ONE, 2L,
        DiceValue.TWO, 1L,
        DiceValue.THREE, 1L,
        DiceValue.FOUR, 1L
    );

    @Test
    void shouldExtractFrequenciesFromDiceRoll() {
        Map<DiceValue, Long> actual = DiceUtils.getDiceFrequencies(asList(1, 1, 2, 3, 4));

        assertThat(actual).isEqualTo(frequencies);
    }

    @Test
    void shouldCalculateRollDiceSumFromFrequencies() {
        int actual = DiceUtils.diceRollSum(frequencies);

        assertThat(actual).isEqualTo(11);
    }
}
