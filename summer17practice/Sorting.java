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
    static Pattern stringRegex = Pattern.compile("^[a-zA-Z \"]+$");
    
    public static void main(String[] args) {
        String raw = "final static String[] ANIMALS = new String[] /* sort */ {\"eland\", \"raymond\", \"antelope\", \"hippopotamus\"};\n";
        String rawTwo = "final static String[] ANIMALS = new String[] /* sort */ {8, 1.2, 1.4, 5, 7, 394};\n";
        // System.out.println(Arrays.toString(processRaw(raw)));
        // System.out.println(samenessChecker(processRaw(raw), "string"));
        String[] stringArray = {"eland", "watermelon"};
        // System.out.println(Arrays.toString(stringArray));
        // System.out.println(Arrays.toString(stringSorter(stringArray)));
        String[] floatArray = {"1", "1.2", "0.4"};
        // System.out.println(Arrays.toString(floatSorter(floatArray)));
        System.out.println(writeOver(raw));
        // System.out.println(raw.substring(0, raw.indexOf("/* sort */") + 13));
        //System.out.println(stringRegex.matcher("eland").matches());
        // System.out.println(detectType(stringArray));
    }
    
    public static String writeOver(String raw) { 
        // get beginning, process array in middle, glue them and output
        String beginning = "";
        
        if(raw.contains("/* sort */")) { 
            beginning = raw.substring(0, raw.indexOf("/* sort */") + 12);
        }
        
        String[] processedArray = processRaw(raw);
        String type = detectType(processedArray);
        
        if(type.equals("float")) { 
            processedArray = floatSorter(processedArray);
        } else { 
            processedArray = stringSorter(processedArray);
        }
        
        // get rid of random whitespace
        for(int i = 0; i < processedArray.length; i++) {
            processedArray[i] = processedArray[i].trim();
        }
        String finalProcess = Arrays.toString(processedArray);
        // get rid of []
        finalProcess = finalProcess.substring(1, finalProcess.length() - 1);
        return beginning + finalProcess + "};";
    }
    
    public static String[] processRaw(String input) {
        int startingIndex;
        // add 13 to bypass the first bracket {
        startingIndex = input.indexOf("/* sort */") + 12;
        // find when the array ends then grab the substring
        int endingIndex = input.indexOf("}");
        return input.substring(startingIndex, endingIndex).split(",");
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
                    return 0;
                } 
            }
            else {
                if(!stringRegex.matcher(inputArray[i]).matches()) {
                    return 0;
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
    
    public static String[] floatSorter(String[] inputArray) {
        String[] returnArray = inputArray;
        int smallestIndex = 0;
        int fillIndex = 0;
        // find smallest from unsorted portion for each item in array
        for(int j = 0; j < returnArray.length; j++) {
            for(int i = fillIndex; i < returnArray.length; i++) {
                if(Double.parseDouble(returnArray[i]) < Double.parseDouble(returnArray[smallestIndex])) {
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
    
    
    
}
