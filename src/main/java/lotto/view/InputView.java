package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        return inputWithPrompt(PURCHASE_AMOUNT_PROMPT);
    }

    public String getWinningNumber() {
        return inputWithPrompt(WINNING_NUMBER_PROMPT);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
