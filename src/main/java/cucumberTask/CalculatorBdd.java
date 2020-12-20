package cucumberTask;

public class CalculatorBdd {

    private static CalculatorBdd instance;

    public static float multiply(float firstNumber, float secondNumber) {
        if (firstNumber <= 0 || firstNumber >= 100) {
            return 0;
        } else if (secondNumber <= 0 || secondNumber >= 100) {
            return 0;
        }
        return firstNumber * secondNumber;
    }

    public static float divide(float numberToBeDivided, float divisor) {
        if (numberToBeDivided < 0 || numberToBeDivided < divisor) {
            return 0;
        } else if (divisor < 0) {
            return 0;
        }
        return (float) (numberToBeDivided / divisor);
    }

    public static float subtract(float firstNumber, float secondNumber) {
        if (firstNumber < 0 || firstNumber < secondNumber) {
            return -1;
        } else if (secondNumber < 0) {
            return -1;
        }
        return (float) (firstNumber - secondNumber);
    }

    public static float add(float firstNumber, float secondNumber) {
        if (firstNumber < 0 || firstNumber >= 100) {
            return -1;
        } else if (secondNumber < 0 || secondNumber >= 100) {
            return -1;
        }
        return  (firstNumber + secondNumber);
    }
}

