package lotto.view;

import java.util.List;
import lotto.constants.PromptConstants;
import lotto.domain.Lotto;

public class OutputView {
    public void printPurchaseLottos(List<Lotto> lottos) {
        String prompt = String.format(PromptConstants.CONFIRM_PURCHASE_COUNT.message, lottos.size());
        System.out.println(prompt);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningStatistics(String result) {
        System.out.println(PromptConstants.WINNING_STATISTICS_HEADER.message);
        System.out.println(PromptConstants.WINNING_STATISTICS_SECTION.message);
        System.out.println(result);
    }

    public void printEarningRate(String earningRate) {
        String prompt = String.format(PromptConstants.PROFIT_RATE_MESSAGE.message, earningRate);
        System.out.println(prompt);
    }

}
