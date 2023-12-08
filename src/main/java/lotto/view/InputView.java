package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputValidator;
import lotto.utils.Parser;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public int getPurchaseAmount() {
        String input = inputWithPrompt(PURCHASE_AMOUNT_PROMPT);
        return InputValidator.validateNonNumeric(input);
    }

    public List<Integer> getWinningNumber() {
        String input = inputWithPrompt(WINNING_NUMBER_PROMPT);
        return Parser.parseWinnginNumbers(input);
    }

    public int getBonusNumber() {
        String input = inputWithPrompt(BONUS_NUMBER_PROMPT);
        return InputValidator.validateNonNumeric(input);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
