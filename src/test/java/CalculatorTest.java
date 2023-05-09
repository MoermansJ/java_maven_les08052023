import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        //INSTANCED - instructions will be executed before each method, example: initialising properties ...
        calculator = new Calculator();
    }

    @BeforeAll
    static void beforeAll() {
        //STATIC - instructions will be executed before all tests, example: establish database connection
    }

    @AfterEach
    void afterAMethod() {
        //INSTANCED - instructions will be executed after each method, example: ???
    }

    @AfterAll
    static void afterAll() {
        //STATIC - instructions will be executed, example: close database connection
    }


    //test method name: should X when Y

    @DisplayName("Checks adding method 2 + 2") //optional alias for method identifier
    @Test
    void shouldReturnEqualsWhenAddingTwoPlusTwo() {
        //given
//        Calculator calculator = new Calculator(); //dec + init is redundant because of setUp()
        int num1 = 2;
        int num2 = 2;

        //when
        int result = calculator.add(num1, num2);

        //then
        assertEquals(4, result);
    }

    @Test
    void shouldReturnEqualsWhenAddingThreePlusSeven() {
        //given
        Calculator calculator = new Calculator();
        int num1 = 3;
        int num2 = 7;

        //when
        int result = calculator.add(num1, num2);

        //then
        assertEquals(10, result);
    }

    @Test
    void shouldReturnThrowsExceptionWhenDividingNineDivideZero() {
        //given
        int num1 = 9;
        int num2 = 0;

        //when
        //import org.junit.jupiter.api.function.Executable; <------ THIS IS THE CORRECT EXECUTABLE IMPORT
        Executable executable = () -> calculator.divide(num1, num2);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }

    @ParameterizedTest
//    @ValueSource(ints = {1, 5, 7}) //handig bij 1 parameter
    @CsvSource(value = {"1, 3, -2"})
        //CSV = Comma Separated Values
    void shouldReturnEqualsWhenSubtractingWithParametersTest(int number1, int number2, int expected) {
        //when
        int actual = calculator.subtract(number1, number2);

        //then
        assertEquals(expected, actual);
    }
}
