import org.junit.jupiter.api.Test;

import java.io.File;

class CSVParserTest {

    //    Test was created just to run the app in some different way, not for assertions
    @Test
    void testCSVParser() {
        ClassLoader classLoader = getClass().getClassLoader();
        var file = new File(classLoader.getResource("operator_and_operation.csv").getFile());

        CSVParser csvParser = new CSVParser();
        csvParser.parseFile(file);
    }
}
