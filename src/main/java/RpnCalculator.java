import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class RpnCalculator {

    int compute(String rpnExpression) {

        Deque<String> deque = new ArrayDeque<>();

        Pattern.compile(" ")
                .splitAsStream(rpnExpression)
                .forEach(operationElement ->
                {
                    if (operationElement.equals("+")) {
                        int leftOperand = parseInt(deque.poll());
                        int rightOperand = parseInt(deque.poll());
                        int result = leftOperand + rightOperand;
                        deque.push(valueOf(result));
                    } else if (operationElement.equals("-")) {
                        int leftOperand = parseInt(deque.poll());
                        int rightOperand = parseInt(deque.poll());
                        int result = rightOperand - leftOperand;
                        deque.push(valueOf(result));
                    } else {
                        deque.push(operationElement);
                    }
                });

        return parseInt(deque.poll());
    }
}
