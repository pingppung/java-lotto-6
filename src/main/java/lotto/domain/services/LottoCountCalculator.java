package lotto.domain.services;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

public class LottoCountCalculator {
    private final int purchaseAmount;

    public LottoCountCalculator(int money) {
        this.purchaseAmount = money;
    }

    public int calculateLottoCount() {
        return purchaseAmount / PURCHASE_PRICE.getValue();
    }
}
