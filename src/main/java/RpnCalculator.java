import static java.lang.Integer.parseInt;

class RpnCalculator {

    int compute(String rpnExpression) {
        if (rpnExpression.length() > 1) {
            String[] operands = rpnExpression.split(" ");
            int leftOperand = parseInt(operands[0]);
            int rightOperand = parseInt(operands[1]);
            return leftOperand + rightOperand;
        }
        return parseInt(rpnExpression);
    }
}
