package lotto.domain.validator;

public class PurchaseAmountValidator {
    public void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 양수의 숫자만 입력가능합니다");
        }
    }
}
