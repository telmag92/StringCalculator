package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator{


    public static int Add(String numbers){
	
	
	if(numbers.equals("")) return 0;
	        
	        
	if((numbers.contains(",") || numbers.contains("\n")) || numbers.startsWith("//")){
	    
	    String[] arr = numbers.split("[^0-9-]+");
	                
	    return sum(arr);
	       
	}
	else if(Integer.parseInt(numbers) < 0) throw new RuntimeException("Negatives not allowed: " + numbers);
	
	else return Integer.parseInt(numbers);
    }



    private static int sum(String[] numbers){
	int total = 0;
	ArrayList<String> arr = new ArrayList<String>();
	for(String number : numbers){
            if(!number.isEmpty()){
		if(Integer.parseInt(number) < 0)
		    {
			arr.add(number);
		    }
		else
		    
		    if (Integer.parseInt(number) <= 1000) total += Integer.parseInt(number);
	    }
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
