import java.util.Arrays;

import static java.lang.Integer.parseInt;

class RpnCalculator {

    int compute(String rpnExpression) {
        String[] operationElements = rpnExpression.split(" ");
        if (operationElements.length == 1) {
            return parseInt(rpnExpression);
        }

        return Arrays.stream(operationElements)
                .filter(s -> !s.equals("+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
