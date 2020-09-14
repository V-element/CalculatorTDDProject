import com.gnevanov.Calculator;
import com.gnevanov.Calculator.Command;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.gnevanov.Calculator.Command.*;

public class CalculatorTest {

    public static final int ZERO = 0;

    private int argument1;
    private int argument2;
    private int result;
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testSum() {
        givenArguments(3,3);
        whenCommandIs(SUM);
        thenResultIs(6);
    }

    @Test
    public void testSumAbs() {
        givenArguments(3,-5);
        whenCommandIs(SUM);
        thenResultIs(8);
    }

    @Test
    public void testDiv() {
        givenArguments(50,10);
        whenCommandIs(DIV);
        thenResultIs(5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivOnZero() {
        givenArguments(100,ZERO);
        whenCommandIs(DIV);
        thenResultThrowsException();
    }

    @Test
    public void testDivAbs() {
        givenArguments(50,-5);
        whenCommandIs(DIV);
        thenResultIs(10);

    }

    @Test
    public void testSubstract() {
        givenArguments(3,3);
        whenCommandIs(SUBSTRACT);
        thenResultIs(0);
    }

    @Test
    public void testSubstractAbs() {
        givenArguments(3,-5);
        whenCommandIs(SUBSTRACT);
        thenResultIs(-2);
    }

    @Test
    public void testPower() {
        givenArguments(3,3);
        whenCommandIs(POWER);
        thenResultIs(9);
    }

    @Test
    public void testPowerAbs() {
        givenArguments(3,-5);
        whenCommandIs(POWER);
        thenResultIs(15);
    }

    private void givenArguments(int arg1, int arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    private void whenCommandIs(Command command) {
        this.result = calculator.calculate(command, argument1, argument2);
    }

    private void thenResultIs(int expectedResult) {
        Assert.assertThat(result, Is.is(expectedResult));
    }

    private void thenResultThrowsException() {
        Assert.fail();
    }
}
