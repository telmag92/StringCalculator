package is.ru.stringcalculator;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

    public static void main(String args[]){

	org.junit.runner.JUnitCore.main("is.ru.StringCalculator.CalculatorTest");
    }

    @Test
    public void testEmptyString(){
	assertEquals(0, Calculator.Add(""));

    }

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

     @Test
    public void testNewLineBetweenNumbers(){
	
	assertEquals(8, Calculator.Add("1\n2,4\n1"));
	assertEquals(8, Calculator.Add("1,4\n3"));
    }
    
    @Test
    public void testNegativeNumbers(){

	try{
	    Calculator.Add("-1,4,-5,3");

	    
	}
	catch(Exception e){
	    assertEquals("Negatives not allowed: -1, -5", e.getMessage());
	    
	}

	try{
            Calculator.Add("-1,2");


        }
	catch(Exception e){
            assertEquals("Negatives not allowed: -1", e.getMessage());

	}
	
	try{
            Calculator.Add("-1");


        }
        catch(Exception e){
            assertEquals("Negatives not allowed: -1", e.getMessage());

        }
    }

    @Test
    public void testBigNumbers(){
	assertEquals(2, Calculator.Add("1001,2"));
	
	assertEquals(5, Calculator.Add("2002\n5"));
    }

    @Test
    public void testAnotherDelimiter(){

	assertEquals(3, Calculator.Add("//:\n1:2"));
	assertEquals(8, Calculator.Add("//;\n1;2;5"));
    }

    @Test
    public void testDelimetersOfAnyLength(){ 

	assertEquals(14, Calculator.Add("//[;;;]\n3;;;6;;;5"));
	assertEquals(10, Calculator.Add("//[::]\n2::7::1"));
    } 

    @Test
    public void testMultipleDelimeters(){

	assertEquals(10, Calculator.Add("//[ppp][y][ee]\n1y2ppp3ee4"));
	assertEquals(19, Calculator.Add("//[;;;][;;][::]\n2;;;3;;4::10"));
	assertEquals(15, Calculator.Add("//[rrr][!][;][::]\n3rrr2!1;5::4"));;


    }

    @Test
    public void testSpecialCharacters(){
	
	assertEquals(19, Calculator.Add("//[***][?]\n2?3***4?10"));
	assertEquals(29, Calculator.Add("//[\n][***][//]\n4\n7//8***10"));
	assertEquals(13, Calculator.Add("//[**][???][!!!!][.]\n1???4!!!!6.**2"));

    }
}
