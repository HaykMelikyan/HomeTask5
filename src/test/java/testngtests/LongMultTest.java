package testngtests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class LongMultTest {

    private Calculator calculator;

    @BeforeClass(groups = {"arithmetictests"})
    public void createCalculator() {
        calculator = new Calculator();
    }

    @AfterClass(groups = {"arithmetictests"})
    public void deleteCalculator() {
        calculator = null;
    }

    @Test(dataProvider = "testParams", groups = {"arithmetictests"})
    public void longMultTest(long a, long b) {
        long expectedResult = a * b;
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }

    @DataProvider(name = "testParams")
    public static Object[][] testData() {
        Object[][] testParams = new Object[3][2];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            testParams[i][0] = random.nextLong();
            testParams[i][1] = random.nextLong();
        }

        return testParams;
    }

}
