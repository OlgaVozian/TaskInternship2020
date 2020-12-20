package cucumberSteps;

import cucumberTask.CalculatorBdd;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class StepImplementation {

    private float result;
    private float firstNumber;
    private float secondNumber;

    @Given("user enters first operator = {} and second operator = {}")
    public void userEntersFirstOperatorAndSecondOperator(Float firstOperator, Float secondOperator) {
        this.firstNumber = firstOperator;
        this.secondNumber = secondOperator;
    }

    @When("user selects {} operation")
    public void userSelectOperation(String operation) {
        switch (operation) {
            case "add":
                result = CalculatorBdd.add(firstNumber, secondNumber);
                break;
            case "subtract":
                result = CalculatorBdd.subtract(firstNumber, secondNumber);
                break;
            case "multiply":
                result = CalculatorBdd.multiply(firstNumber, secondNumber);
                break;
            case "divide":
                result = CalculatorBdd.divide(firstNumber, secondNumber);
                break;
        }
    }

    @Then("the result should be {}")
    public void resultShouldBeEqualTo(float expectedExpected) {
        assertThat("verify expected result", this.result, is(expectedExpected));
    }


    @Given("two numbers are entered")
    public void two_numbers_are_entered(DataTable dataTable) {
        List<Map<String, String>> numbers = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> operation:numbers){
            userEntersFirstOperatorAndSecondOperator(Float.valueOf(operation.get("firstNumber")), Float.valueOf(operation.get("secondNumber")));
                    userSelectOperation(operation.get ("operator"));
                    resultShouldBeEqualTo(Float.valueOf(operation.get("results")));
        }

    }
}
