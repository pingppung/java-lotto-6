package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.domain.Lotto;
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

    @DisplayName("로또번호_리스트에서_중복되는_수가_없는_경우")
    @Test
    void validateDuplicateNumbers() {
        List<Integer> valideNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> LottoNumberValidator.validateDuplicateNumbers(valideNumbers));
    }

    @DisplayName("로또번호_리스트에서_중복되는_수가_존재하는_경우")
    @Test
    void invalidateDuplicateNumbers() {
        List<Integer> invalideNumbers = List.of(1, 2, 3, 3, 4, 5);
        assertThatThrownBy(() -> LottoNumberValidator.validateDuplicateNumbers(invalideNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 존재합니다.");
    }

    @DisplayName("보너스번호가_로또번호와_중복되는_수가_없는_경우")
    @Test
    void validateDuplicateBonus() {
        Lotto lotto_numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertDoesNotThrow(() -> LottoNumberValidator.validateDuplicateBonus(lotto_numbers, bonus));
    }

    @DisplayName("보너스번호가_로또번호와_중복되는_수가_존재하는_경우")
    @Test
    void invalidateDuplicateBonus() {
        Lotto lotto_numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;
        assertThatThrownBy(() -> LottoNumberValidator.validateDuplicateBonus(lotto_numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 존재합니다.");
    }
}
