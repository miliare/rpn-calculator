import static java.lang.Integer.parseInt;

class RpnCalculator {

    int compute(String rpnExpression) {
        String[] operands = rpnExpression.split(" ");
        if (operands.length == 1) {
            return parseInt(rpnExpression);
        }
        int firstOperand = parseInt(operands[0]);
        int secondOperand = parseInt(operands[1]);
        if (operands.length > 3) {
            int rightOperand = parseInt(operands[3]);
            return firstOperand + secondOperand + rightOperand;
        }
        return firstOperand + secondOperand;
    }
}
