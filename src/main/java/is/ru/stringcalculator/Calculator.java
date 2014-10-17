package is.ru.stringcalculator;

public class Calculator{


    public static int Add(String numbers){


        if(numbers.equals("")) return 0;
        
        else if(numbers.contains(",")){
            return sum(splitNumbers(numbers));
        }
        
        else return Integer.parseInt(numbers);
        
    }


    private static String[] splitNumbers(String numbers){
	return numbers.split(",|\n");
    }


    private static int sum(String[] numbers){
	int total = 0;
	for(String number : numbers){
	    total += Integer.parseInt(number);
	}
	return total;
    }



}
