package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {

    @DisplayName("구입 금액에 음수를 입력했을 경우 예외처리")
    @Test
    public void invalidatePositiveNumber() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수의 숫자만 입력가능합니다");
    }

    @DisplayName("유효한 구입 금액의 범위인 양수를 입력했을 경우")
    @Test
    public void validatePositiveNumber() {
        assertDoesNotThrow(() -> PurchaseAmountValidator.validatePositiveNumber(1));
    }

    @DisplayName("1000원 단위가 아닌 경우 예외 발생")
    @Test
    public void invalidateNotDivisibleByThousand() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateNotDivisibleByThousand(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("1000원 단위로 나눠지는 경우 예외 미발생")
    @Test
    public void validateNotDivisibleByThousand_ShouldNotThrowExceptionForNotDivisibleNumber() {
        assertDoesNotThrow(() -> PurchaseAmountValidator.validatePositiveNumber(10000));
    }
}
