public class Calculator {

    public static double multiply(double firstNumber, double secondNumber) {
        if ((firstNumber >= 0 && firstNumber <= 100) && (secondNumber >= 0 && secondNumber <= 100)) {
            return firstNumber * secondNumber;
        } else {
            return 0;
        }
    }

    public static int subtract(int firstNumber, int secondNumber) {
        if (firstNumber >= 0 && secondNumber >= 0 && (firstNumber >= secondNumber)) {
            return firstNumber - secondNumber;
        } else {
            return -1;
        }
    }

    public static double divide(double numberToBeDivided, double divisor) throws DivideByZeroException{
        if (divisor != 0) {
            if (numberToBeDivided >= 0 && divisor >= 0 && (numberToBeDivided >= divisor)) {
                return numberToBeDivided / divisor;
            }
        }else {
            throw new DivideByZeroException();
        }
        return 0;
    }
}
