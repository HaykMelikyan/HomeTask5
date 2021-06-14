package junittests;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class PowTest {

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
    public void powTest() {
        double a = random.nextDouble();
        double b = random.nextDouble();
        double expectedResult = Math.pow(a, b);
        Assert.assertEquals(expectedResult, calculator.pow(a, b), 0.00001);
    }
}
