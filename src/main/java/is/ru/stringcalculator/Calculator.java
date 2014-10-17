package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator{


    private static String appendFinalDelimeter = "";
    // private static String delimeter = ",|\n"; // <=== base delimeter
  
    public static int Add(String numbers){

	//String pattern = "//.+\n.+";
	
        if(numbers.equals("")) return 0;
        
        String pattern = "//.+\n.+";
        
        
        boolean matches = Pattern.matches(pattern, numbers);
        
        if((numbers.contains(",") || numbers.contains("\n")) || matches){
	    
     
	    String delimeter = ",|\n"; // <=== base delimeter
           
	    if(matches){
		
		pattern = "//.+\n";
		
		
		String pattern2 = "([0-9].+[0-9])+"; 
		Matcher match2 = Pattern.compile(pattern2).matcher(numbers);
		

		Matcher match = Pattern.compile(pattern).matcher(numbers);
		numbers = match.replaceAll("");
      
		String newDelimeter = match2.replaceAll("");
           
		if(newDelimeter.contains("[")){
		    
		    newDelimeter = newDelimeter.replace("[", "");
		    newDelimeter = newDelimeter.substring(2, newDelimeter.length()-2);
		    String [] finalSolution = newDelimeter.split("]");
		    for(String k : finalSolution){
			appendFinalDelimeter = appendFinalDelimeter.concat("|" + k);
		    }
		    
		}
		else appendFinalDelimeter = newDelimeter.concat("|"+newDelimeter.substring(2, newDelimeter.lastIndexOf('\n')));      
		
	    }

            
            if(!appendFinalDelimeter.isEmpty()) delimeter = delimeter.concat(appendFinalDelimeter);
	    
	    
            
            String [] arr2 = numbers.split(delimeter);
            
            return sum(arr2);
            
            
            
            
        }
        else if(Integer.parseInt(numbers) < 0) throw new RuntimeException("Negatives not allowed: " + numbers);
        
        else return Integer.parseInt(numbers);
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
		
		if (Integer.parseInt(number) <= 1000) total += Integer.parseInt(number);
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
