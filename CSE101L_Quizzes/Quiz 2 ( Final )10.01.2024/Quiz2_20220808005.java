import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


/**
 * -----------------------------------------------------
 * Akdeniz University CSE101L Lab Quiz2 (Final)
 * Name: Yahya Efe Kurucay
 * Date: 10.01.2024
 * Description: Quiz2
 * Score: 
 * Website: https://efekurucay.com
 *-----------------------------------------------------
 */
public class Quiz2_20220808005 {
//-----main------//
    public static void main(String[] args) {
        
        System.out.println("------sort control--------");
        //sort control
        String a ="yaHjlao";
        System.out.println(sort(a));
        System.out.println("------LockerPuzzle control--------");

        //LockerPuzzle control
        int n = 100;
        boolean[] lockers = new boolean[n];
        int[] openLockers = lockerPuzzle(lockers);
        System.out.print("Amount of open lockers : ");
        System.out.println( openLockers.length);

        // isMarkovMatrix control
        System.out.println("------isMarkovMatrix control--------");
         double[][] matrix = {
                    {0.5, 0.3, 0.2},
                    {0.1, 0.7, 0.2},
                    {0.2, 0.1, 0.7}
            };
         if (isMarkovMatrix(matrix)==true) {
                System.out.println("The matrix is a Markov matrix.");
         } else {
                System.out.println("The matrix is not a Markov matrix.");
            }
       
         System.out.println("------movingAverage control--------");
        //movingAverage control
        String sourceFileName = "source.txt";
        String destinationFileName = "destination.txt";
        int windowSize = 5;
        movingAverage(sourceFileName, destinationFileName, windowSize);
        System.out.println("Moving average calculation completed.");


        System.out.println("------factorial control--------");
        //factorial control
        System.out.println(factorial(4));

        System.out.println("------isPalindrome control --------");
        //isPalindrome control  
        System.out.println(isPalindrome("efe"));

        System.out.println("------decimalToBinary control--------");
        //decimalToBinary control

        for (int i = 0; i < 8; i++) {
            int[]binary= decimalToBinary(64);
            System.out.print(binary[i]);
        }



 
    }

//-------1--------// **DONE
    public static String sort(String text) {
    	char[] chars = text.toCharArray();
    	boolean notSorted = true;
    	for (int i = 1; i < chars.length && notSorted; i++) {
        	notSorted = false; 
        	for (int j = 0; j < chars.length - i; j++) {
            	if (chars[j] > chars[j + 1]) {
                	chars = swap(j, j + 1, chars);
                	notSorted = true;
            	}
        	}
    	}
    	return Arrays.toString(chars);


	}

    //swap method for sorting string in 1. question **DONE
	public static char[] swap(int i1, int i2, char[] arr) {
    	char temp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = temp;

    	return arr;


	}

//------2--------// ** DONE
    public static int[] lockerPuzzle(boolean[] locker) {
       

         //Students are changing open to closed or closed to open.
        for (int s = 1; s <= locker.length; s++) {
             for (int i = s - 1; i < locker.length; i += s) {
                   locker[i] = !locker[i];
              }
        }
        // count the all open lockers
        int open= 0; for (boolean isOpen : locker) {if (isOpen) {open++;}}

        // store the index of open lockers to new array
        int[] openLockers = new int[open]; int index = 0;
        for (int i = 0; i < locker.length; i++) {
             if (locker[i]) { openLockers[index] = i + 1;  index++;}
        }

        return openLockers;
    }

//------3-------// **DONE
    public static boolean isMarkovMatrix(double[][] matrix) {

            // Check if the matrix is n*n matrix
            int rows = matrix.length;
            int cols = matrix[0].length;
    
            if (rows != cols) {
                return false;
            }
    
            // Check if all elements are positive
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] <= 0) {
                        return false;
                    }
                }
            }
    
            // Check if the sum of elements in each column is 1
            for (int j = 0; j < cols; j++) {
                double sum = 0.0;
                for (int i = 0; i < rows; i++) {
                    sum += matrix[j][i];
                }
                if (sum != 1.0) {
                    return false;
                }
            }
    
            // If all conditions are met, the matrix is a Markov matrix
            return true;
        }
    
//------4-------// **DONE
public static void movingAverage(String sourceFileName, String destinationFileName, int windowSize) {
    try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
         BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

        double[] window = new double[windowSize];
        int index = 0;
        double sum = 0.0;

        String line;
        while ((line = reader.readLine()) != null) {
            double value = Double.parseDouble(line.trim());

            sum += value;
            window[index % windowSize] = value;

            if (index >= windowSize - 1) {
                double movingAverage = sum / windowSize;
                writer.write(String.format("%.1f", movingAverage));
                writer.newLine();
                sum -= window[(index - windowSize + 1) % windowSize];
            }

            index++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

//------5-------// **DONE
    // **DONE
    public static long factorial(int n){

        if(n == 0){

            return 1;

        }else{

            return n*factorial(n-1);

        }

    }
    // **DONE
    public static int[] decimalToBinary(int number) {

        int[] binary = new int[9];
        int c = binary.length - 1;
        while (number > 0) {
            if (number % 2 == 0) binary[c] = 0;
            else if (number % 2 == 1) binary[c] = 1;
            c--;
            number = number / 2;
        }

        return binary;

    }
    // **DONE
    public static boolean isPalindrome(String str) {
    // Base case: an empty string or a string with a single character is a palindrome
    if (str.length() <= 1) {
        return true;
    }

    // Check if the first and last characters are the same
    if (str.charAt(0) != str.charAt(str.length() - 1)) {
        return false;
    }

    // Recursive call with the substring excluding the first and last characters
    return isPalindrome(str.substring(1, str.length() - 1));
}
   
}