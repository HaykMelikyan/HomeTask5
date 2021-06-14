package junittests;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class SinTest {

    private static Calculator calculator;
    private static final Random random = new Random();

    @BeforeClass
    public static void createCalculator() {
        calculator = new Calculator();
    }

    @AfterClass
    public static void deleteCalculator() {
        calculator = null;
    }

    @Test
    public void sinTest() {
        double a = random.nextDouble();
        double expectedResult = Math.sin(a);
        Assert.assertEquals(expectedResult, calculator.sin(a), 0.00001);
    }
}
