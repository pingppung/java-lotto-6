package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @DisplayName("입력값에_유효한_숫자만_입력된_경우")
    @Test
    void validateNonNumeric() {
        String input = "123";
        assertDoesNotThrow(() -> InputValidator.validateNonNumeric(input));
    }

    @DisplayName("입력값에_문자가_포함된_경우")
    @Test
    void invalidateNonNumeric() {
        String input = "a1b2";
        assertThatThrownBy(() -> InputValidator.validateNonNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다");
    }
}
