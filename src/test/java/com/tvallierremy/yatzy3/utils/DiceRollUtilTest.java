package com.tvallierremy.yatzy3.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class DiceRollUtilTest {

    @Test
    void shouldExtractFrequenciesFromDiceRoll() {
        Map<Integer, Integer> actual = DiceRollUtil.frequencies(asList(1, 1, 2, 3, 4));

        Map<Integer, Integer> expected = Map.of(
            1, 2,
            2, 1,
            3, 1,
            4, 1,
            5, 0,
            6, 0
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldCalculateRollDiceSumFromFrequencies() {
        int actual = DiceRollUtil.sum(asList(1, 1, 2, 3, 4));

        assertThat(actual).isEqualTo(11);
    }

}
