package lotto.domain;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

import lotto.domain.validator.PurchaseAmountValidator;

public class LottoPurchase {

    public LottoPurchase(int money) {
        validate(money);
        calculateLottoCount(money);
    }

    private void validate(int money) {
        PurchaseAmountValidator.validateNotDivisibleByThousand(money);
    }

    public int calculateLottoCount(int money) {
        return money / PURCHASE_PRICE.getValue();
    }
}
