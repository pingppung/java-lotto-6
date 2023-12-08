package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {

    @DisplayName("유효한_범위_내의_숫자로_테스트")
    @Test
    void validNumberInRange() {
        int validNumber = 45;
        assertDoesNotThrow(() -> LottoNumberValidator.validateNumberInRange(validNumber));
    }

    @DisplayName("유효하지_않은_범위_내의_숫자로_테스트")
    @Test
    void invalidNumberInRange() {
        int invalidNumber = 46;
        assertThatThrownBy(() -> LottoNumberValidator.validateNumberInRange(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 숫자만 가능합니다.");
    }
}
