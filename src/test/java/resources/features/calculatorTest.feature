Feature: calculator tests

  @Run
  Scenario: calculator test sum

    Given user enters first operator = 0 and second operator = 50
    When   user selects add operation
    Then the result should be 50.0

  @Run
  @Bug
  Scenario: calculator test multiply fail

    Given user enters first operator = 10 and second operator = 50
    When   user selects multiply operation
    Then the result should be 50.0

  @Run
  Scenario Outline: calculator test list

      Given user enters first operator = <firstNumber> and second operator = <secondNumber>
      When  user selects <operation> operation
      Then the result should be <result>

      Examples:

        | operation | firstNumber | secondNumber | result |
        | add       | 0f          | 5f           | 5f     |
        | multiply  | 5f          | 2f           | 10f    |
        | divide    | 2f          | 2f           | 1f     |
        | subtract  | 8f          | 4f           | 4f     |

  @Run
  Scenario: calculator test map

    Given two numbers are entered
      | firstNumber | secondNumber | operator | results |
      | 0f          | 5f           | add      | 5f      |
      | 5f          | 2f           | multiply | 10f     |
      | 2f          | 2f           | divide   | 1f      |
      | 8f          | 4f           | subtract | 4f      |