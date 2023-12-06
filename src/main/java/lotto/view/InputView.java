package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

    public String getPurchaseAmount() {
        return inputWithPrompt(PURCHASE_AMOUNT_PROMPT);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
