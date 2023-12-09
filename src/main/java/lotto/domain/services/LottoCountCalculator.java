package lotto.domain.services;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

import lotto.domain.validator.PurchaseAmountValidator;

public class LottoCountCalculator {
    private final int purchaseAmount;

    public LottoCountCalculator(int money) {
        validate(money);
        this.purchaseAmount = money;
    }

    private void validate(int money) {
        PurchaseAmountValidator.validateNotDivisibleByThousand(money);
    }

    public int calculateLottoCount() {
        return purchaseAmount / PURCHASE_PRICE.getValue();
    }
}
