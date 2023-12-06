package lotto.domain;

import static lotto.constants.LottoConstants.PURCHASE_PRICE;

public class LottoPurchase {

    public LottoPurchase(String moneyInput) {
        calculateLottoCount(Integer.parseInt(moneyInput));
    }

    public int calculateLottoCount(int money) {
        return money / PURCHASE_PRICE.getValue();
    }
}
