import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

class RpnCalculator {

    int compute(String rpnExpression) {

        Deque<Integer> deque = new ArrayDeque<>();

        Pattern.compile(" ")
                .splitAsStream(rpnExpression)
                .forEach(operationElement ->
                {
                    if (Operator.isOperator(operationElement)) {
                        int result = Operator.of(operationElement).compute(deque.poll(), deque.poll());
                        deque.push(result);
                    } else {
                        deque.push(valueOf(operationElement));
                    }
                });

        return deque.poll();
    }

    private enum Operator {

        ADD("+", (i1, i2) -> i1 + i2),
        SUB("-", (i1, i2) -> i2 - i1);

        private final String symbol;
        private final IntBinaryOperator operator;

        Operator(String symbol, IntBinaryOperator operator) {
            this.symbol = symbol;
            this.operator = operator;
        }

        public static boolean isOperator(String s) {
            return findOperatorBySymbol(s).isPresent();
        }

        public static Operator of(String symbol) {
            return findOperatorBySymbol(symbol).orElse(null);
        }

        private static Optional<Operator> findOperatorBySymbol(String symbol) {
            return Arrays.stream(values()).filter(op -> op.symbol.equals(symbol)).findAny();
        }

        public int compute(int i1, int i2) {
            return operator.applyAsInt(i1, i2);
        }
    }
}
