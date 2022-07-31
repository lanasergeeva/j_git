package ru.job4j.ex.array;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ex.array.JavaNameValidator.isNameValid;


class JavaNameValidatorTest {
    @Test
    void whenFullLatValid() {
        assertThat(isNameValid("first")).isTrue();
    }

    @Test
    void whenLatNumberValid() {
        assertThat(isNameValid("first1")).isTrue();
    }

    @Test
    void whenLatNumberUnderValid() {
        assertThat(isNameValid("first_user")).isTrue();
    }

    @Test
    void whenNumberInValid() {
        assertThat(isNameValid("123")).isFalse();
    }

    @Test
    void whenWrongSymbolInValid() {
        assertThat(isNameValid("leeRo%%yJen")).isFalse();
    }

    @Test
    void whenWrongSymbolInValidSecond() {
        assertThat(isNameValid("leeRoy-Jenkins")).isFalse();
    }

    @Test
    void whenEmpty() {
        assertThat(isNameValid("")).isFalse();
    }

    @Test
    void whenUpperFirst() {
        assertThat(isNameValid("Lee")).isFalse();
    }
}