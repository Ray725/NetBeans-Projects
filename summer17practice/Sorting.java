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
    
    static Pattern floatingRegex = Pattern.compile("[-+]?[0-9 ]*\\.?[0-9 ]+");
    static Pattern stringRegex = Pattern.compile("^[a-zA-Z ]+$");
    
    public static void main(String[] args) {
        String[] inputArray = {"141.24", "12"};
        System.out.println(detectType(inputArray));
    }
    
    // need to make a function that processes raw into String[]
    
    // go through each array and check items individually
    public static String detectType(String[] inputArray) {
        // verify type based on first thing in array
        String type;
        if(floatingRegex.matcher(inputArray[0]).matches()) {
            type = "float";
        } else {
            type = "string";
        }
        
        // guarantee samenessChecker is run
        if(samenessChecker(inputArray, type) == 1) {
            return type;
        } else {
            return "ERROR";
        }
    }
    
    public static int samenessChecker(String[] inputArray, String type) {
        // throw an exception if inconsistent input
        for(int i = 0; i < inputArray.length; i++) {
            if (type.equals("float")) { 
                if(!floatingRegex.matcher(inputArray[i]).matches()) {
                    throw new IllegalArgumentException();
                } 
            }
            else {
                if(!stringRegex.matcher(inputArray[i]).matches()) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return 1;
    }
    
    public static void stringSorter() {
    }
    
    public static void floatSorter() {
    }
    
}
