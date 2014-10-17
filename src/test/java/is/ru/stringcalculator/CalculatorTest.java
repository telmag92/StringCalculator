package is.ru.stringcalculator;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

    public static void main(String args[]){

	org.junit.runner.JUnitCore.main("is.ru.StringCalculator.CalculatorTest");
    }

    @Test
    public void testEmptyString(){assertEquals(0, Calculator.Add(""));}

    @Test
    public void test1number(){
	assertEquals(1, Calculator.Add("1"));

	assertEquals(10, Calculator.Add("10"));
    }

    @Test
    public void testTwoNumbers() {
	assertEquals(3, Calculator.Add("1,2"));
    }

    @Test
    public void testMultipleNumbers(){
	assertEquals(6, Calculator.Add("1,2,3"));
    }



}
