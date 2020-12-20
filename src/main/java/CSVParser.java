import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class CSVParser implements Parser {

    private static final Logger logger = LoggerFactory.getLogger(CSVParser.class);

    @Override
    public void parseFile(File file) {
        try {
            var csvContent = new BufferedReader(new FileReader(file)).lines().collect(toList());
            csvContent.forEach(element -> {
                logger.info("current csv line =" + element);
                var splitValues = element.split(",");
                var operand1 = splitValues[0];
                var operand2 = splitValues[2];
                var operator = splitValues[1];

                var operationEnum = Arrays.stream(ArithmeticOperationEnum.values())
                        .filter(operationElement -> operationElement.arithmeticSign.equals(operator))
                        .findFirst()
                        .orElseThrow(() -> new ArithmeticException("An ArithmeticException occurred during arithmetic operation with "
                                + operator + " sign  - unsupported operation!!!"));

                var arithmeticResult = operationEnum.arithmeticOperation(Long.valueOf(operand1), Long.valueOf(operand2));
                logger.info("result of the " + operator + " operation with operand1 = " + operand1 +
                        " and operand2 = " + operand2 + " is equal with = " + arithmeticResult);
            });
        } catch (FileNotFoundException e) {
            logger.warn("the application was unable to open the " + file.getName() + " file, please check if the file exist and isn't damaged");
            e.printStackTrace();
        }
    }
}
