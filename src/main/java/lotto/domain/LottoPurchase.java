package lotto.domain;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

import lotto.domain.validator.PurchaseAmountValidator;

public class LottoPurchase {
    private final int purchaseAmount;

    public LottoPurchase(int money) {
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
