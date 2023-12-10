package lotto.utils;

public class InputHandler {
    public static <T> T retryInputOnInvalid(InputSupplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    public interface InputSupplier<T> {
        T get() throws IllegalArgumentException;
    }
}
