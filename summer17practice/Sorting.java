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
        String[] inputArray = {"z", "b", "asdf", "c", "d", "agj"};
       
        System.out.println(Arrays.toString(stringSorter(inputArray)));
        // System.out.println(detectType(inputArray));
        // need to make a function that processes raw into String[]
    }
    
    
    
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
    
    // use selection sort
    public static String[] stringSorter(String[] inputArray) {
        String[] returnArray = inputArray;
        int smallestIndex = 0;
        int fillIndex = 0;
        // find smallest from unsorted portion for each item in array
        for(int j = 0; j < returnArray.length; j++) {
            for(int i = fillIndex; i < returnArray.length; i++) {
                if(returnArray[i].compareTo(returnArray[smallestIndex]) < 0) {
                    smallestIndex = i;
                }
            }
            // swap 
            String temp = returnArray[fillIndex];
            returnArray[fillIndex] = returnArray[smallestIndex];
            returnArray[smallestIndex] = temp;
                
            // setup for next run-through
            fillIndex++;
            smallestIndex = fillIndex;
        }
        return returnArray;
    }
    
    public static void floatSorter(double[] inputArrray) {
        
    }
    
}
