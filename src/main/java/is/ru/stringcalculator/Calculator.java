package is.ru.stringcalculator;
import java.util.ArrayList;
public class Calculator{


    public static int Add(String numbers){


        if(numbers.equals("")) return 0;
        
        else if(numbers.contains(",")){
            return sum(splitNumbers(numbers));
        }
       
	
	else if(Integer.parseInt(numbers) < 0) throw new RuntimeException("Negatives not allowed: " + numbers);
        
        else return Integer.parseInt(numbers);
        
    }


    private static String[] splitNumbers(String numbers){
	return numbers.split(",|\n");
    }


    private static int sum(String[] numbers){
	int total = 0;
	ArrayList<String> arr = new ArrayList<String>();
	for(String number : numbers){
            if(Integer.parseInt(number) < 0)
		{
		    arr.add(number);
		}
            else
		total += Integer.parseInt(number);
	}
            
            
	if(!arr.isEmpty()){
            int counter = 0;
            String negatives = "";
            for(String a : arr)
		{
		    negatives += a;
		    if(counter != arr.size() - 1 ){
			negatives += ", ";
		    }
		    counter++;
		}
            
            throw new RuntimeException("Negatives not allowed: " + negatives);
	}
	return total;
    }



}
