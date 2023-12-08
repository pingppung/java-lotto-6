package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
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

    @DisplayName("6개의_숫자_리스트_테스트")
    @Test
    void validateNumbersCount() {
        List<Integer> valideNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> LottoNumberValidator.validateNumbersCount(valideNumbers));
    }

    @DisplayName("6개의_숫자로_이루어지지_않은_리스트_테스트")
    @Test
    void invalidateNumbersCount() {
        List<Integer> invalideNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> LottoNumberValidator.validateNumbersCount(invalideNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개이여야 합니다.");
    }
}