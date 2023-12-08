package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
