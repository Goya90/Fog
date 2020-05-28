package FunctionLayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 Denne klasse tester Calculator. Der oprettes en arrayliste, testBom, med materialeobejkter, som cleares igen efter brug.
 Der skabes også en ny instans af Caclulator.
 */
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

    /**
    Test af en carport med fladt tag, uden skur. Der testes på, om antallet af materialer stemmer overens, samt om totalprisen på materialer er korrekt.
     */
    @Test
    public void calculatorTest1() throws LoginSampleException, ClassNotFoundException {

        testBom = cal.bomCalculator(4400, 4800, 2400,
                true, "plastmo sort", 0, 0);
        double totalPrice = 0.0;
        for (Material mat : testBom){
            totalPrice = totalPrice+mat.getPrice();
        }
        assertEquals(8475.0, totalPrice, 0.0);
        assertThat(testBom, hasSize(14));
                }

    /**
     Test af en carport med fladt tag, med skur. Der testes på, om antallet af materialer stemmer overens, samt om totalprisen på materialer er korrekt..
     */
    @Test
    public void calculatorTest2() throws LoginSampleException, ClassNotFoundException {
        testBom = cal.bomCalculator(4400, 4800, 2400,
                true, "plastmo sort", 2800, 2400);
        double totalPrice = 0.0;
        for (Material mat : testBom){
            totalPrice = totalPrice+mat.getPrice();
        }
        assertEquals(9860.0, totalPrice, 0.0);

        assertThat(testBom, hasSize(18));
    }

    /**
     Test af en carport med rejsning, med skur. Der testes på, om antallet af materialer stemmer overens, samt om totalprisen på materialer er korrekt..
     */

    @Test
    public void calculatorTest3() throws LoginSampleException, ClassNotFoundException {

        testBom = cal.bomCalculator(3400, 2800, 2200,
                false, "Tagpap sort", 2800 , 2400);
        double totalPrice = 0.0;
        for (Material mat : testBom){
            totalPrice = totalPrice+mat.getPrice();
        }
        assertEquals(21540.0, totalPrice, 0.0);

        assertThat(testBom, hasSize(22));
    }

    /**
     Test af en carport med rejsning, uden skur. Der testes på, om antallet af materialer stemmer overens, samt om totalprisen på materialer er korrekt..
     */
    @Test
    public void calculatorTest4() throws LoginSampleException, ClassNotFoundException {
                testBom = cal.bomCalculator(3400, 2800, 2200,
                false, "Tagpap sort", 0 , 0);
        double totalPrice = 0.0;
        for (Material mat : testBom){
            totalPrice = totalPrice+mat.getPrice();
        }
        assertEquals(19935.0, totalPrice, 0.0);
                assertThat(testBom, hasSize(18));

    }
}
