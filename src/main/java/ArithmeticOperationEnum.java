public enum ArithmeticOperationEnum {

    DIVISION("/") {
        @Override
        public Long arithmeticOperation(Long element1, Long element2) {
            return element1 / element2;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public Long arithmeticOperation(Long element1, Long element2) {
            return element1 * element2;
        }
    },

    ADDITION("+") {
        @Override
        public Long arithmeticOperation(Long element1, Long element2) {
            return element1 + element2;
        }
    },

    SUBTRACTION("-") {
        @Override
        public Long arithmeticOperation(Long element1, Long element2) {
            return element1 - element2;
        }
    },

    MODULUS("%") {
        @Override
        public Long arithmeticOperation(Long element1, Long element2) {
            return element1 % element2;
        }
    };

    public String arithmeticSign;

    ArithmeticOperationEnum(String arithmeticSign) {
        this.arithmeticSign = arithmeticSign;
    }

    public abstract Long arithmeticOperation(Long element1, Long element2);
}
