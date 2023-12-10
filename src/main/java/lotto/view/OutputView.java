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

    public void printWinningStatistics(String result) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println(result);
    }
}
