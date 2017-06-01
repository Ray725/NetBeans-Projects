/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summer17practice;
import java.util.Arrays;
import java.util.regex.*;

/**
 *
 * @author raymondli
 */
public class Sorting {
    
    static Pattern floatingRegex = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
    static Pattern stringRegex = Pattern.compile("^[a-zA-Z]+$");
    
    public static void main(String[] args) {
        // the sameness checker isn't working
    }
    
    // go through each array and check items individually
    public static String detectType(String input) {
        // split input into an array to individually check
        String[] inputArray = input.split(",");
        
        // outputs whether something matches regex p
        // boolean matches = floatingRegex.matcher("12").matches();
        
        String type;
        if(floatingRegex.matcher(inputArray[0]).matches()) {
            type = "float";
        } else {
            type = "string";
        }
        
        return type;
    }
    
    public static void samenessChecker(String[] inputArray, String type) {
        // throw an exception if inconsistent input
        for(int i = 0; i < inputArray.length; i++) {
            if (type.equals("float")) 
                if(!floatingRegex.matcher(inputArray[i]).matches()) 
                    throw new IllegalArgumentException();
            else 
                if(!stringRegex.matcher(inputArray[i]).matches()) 
                    throw new IllegalArgumentException();
        }
    }
    
}
