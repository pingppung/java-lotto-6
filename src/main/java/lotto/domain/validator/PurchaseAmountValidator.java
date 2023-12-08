package lotto.domain.validator;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

public class PurchaseAmountValidator {
    public static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 양수의 숫자만 입력가능합니다");
        }
    }

    public static void validateNotDivisibleByThousand(int number) {
        if (number % PURCHASE_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }

    }
}
