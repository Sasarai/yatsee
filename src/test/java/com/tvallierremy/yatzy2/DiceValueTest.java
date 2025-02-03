package com.tvallierremy.yatzy2;

import com.tvallierremy.yatzy2.exception.DiceValueNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.tvallierremy.yatzy2.DiceValue.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

class DiceValueTest {
    @ParameterizedTest
    @MethodSource("diceValueTestArguments")
    void shouldReturnCorrectDiceValue(int diceValue, DiceValue expected) {
        DiceValue actual = DiceValue.getFromValue(diceValue);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> diceValueTestArguments() {
        return Stream.of(
            of(1, ONE),
            of(2, TWO),
            of(3, THREE),
            of(4, FOUR),
            of(5, FIVE),
            of(6, SIX)
        );
    }

    @Test
    void shouldThrowsDiceValueNotFoundExceptionIfValueIsInvalid() {
        assertThatThrownBy(() -> DiceValue.getFromValue(-1))
            .isInstanceOf(DiceValueNotFound.class);
    }
}
