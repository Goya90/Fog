package FunctionLayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    ArrayList<Material> testBom;
    Calculator cal;

    @Before
    public void setUp(){
    cal = new Calculator();
    }

    @After
    public void tearDown() {

        testBom.clear();
    }

    @Test
    //Test af en carport med fladt tag, uden skur
            public void calculatorTest1() throws LoginSampleException, ClassNotFoundException {

        testBom = cal.bomCalculator(4400, 4800, 2400,
                true, "plastmo sort", 0, 0);

        assertThat(testBom, hasSize(13));
        }

    @Test
    //Test af samme carport med fladt tag, med skur
        public void calculatorTest2() throws LoginSampleException, ClassNotFoundException {
        testBom = cal.bomCalculator(4400, 4800, 2400,
                true, "plastmo sort", 2800, 2400);

        assertThat(testBom, hasSize(17));

    }

    @Test
    //Act - Test af carport med rejsning, med skur
    public void calculatorTest3() throws LoginSampleException, ClassNotFoundException {

        testBom = cal.bomCalculator(3400, 2800, 2200,
                false, "Tagpap sort", 2800 , 2400);
        assertThat(testBom, hasSize(17));

    }

    @Test
    //Act - Test af samme carport med rejsning, uden skur
    public void calculatorTest4() throws LoginSampleException, ClassNotFoundException {
                testBom = cal.bomCalculator(3400, 2800, 2200,
                false, "Tagpap sort", 0 , 0);
                assertThat(testBom, hasSize(13));

    }
}
