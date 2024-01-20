import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.catalog.Catalog;
/*
 * *-----------------------------------------------------
* Akdeniz University CSE101L Lab Assignments
* Name: Burak Yalçın
* Date: 03.01.2024
* Description: Exercise08
* Score: 67
*-----------------------------------------------------
 */
public class Ex08_20220808037 {
    public static void main(String[] args) {
        readFilterPokeStats("PokeStats.txt");
        
    }
     // Question 1: Log unspecified number of integers
     public static void intLogger(String filename) {
        /*
         * Write a method that logs all integers entered to the console.
         * Your method must handle FileNotFoundException and 
         * InputMismatchException exceptions. 
         * Exception handling message should take only one line in console.
         * Each input has to be logged in separate line.
         * If non-integer number entered to the console: log it as
         * "non-integer-input" (without ") to the text file (specified 
         * with filename). And continues to take inputs.
         * Take inputs until 0 entered. (log 0 too.)
         * 
         * Args:
         *      filename: String that specifies the target log file.
         */

         // Your code goes here...
        File file = new File(filename);
        Scanner scan = new Scanner(System.in);
        try{
            
            PrintWriter writer = new PrintWriter(file);
            int a;
            do{
                a =scan.nextInt();
                writer.print(a+ " ");
            }while(a != 0);
            scan.close();
            writer.close();
            Scanner fileReader = new Scanner(file);
            if(!fileReader.hasNext()){
                PrintWriter writer1 = new PrintWriter(file);
                writer1.println("non-integer-input");
                writer1.close();
            }

        }catch(FileNotFoundException e){
            System.out.print(e);
        }catch(InputMismatchException e){
            System.out.print(e);
            try{
                Scanner fileReader = new Scanner(file);
                if(!fileReader.hasNext()){
                    PrintWriter writer = new PrintWriter(file);
                    writer.print("non-integer-input");
                    writer.close();
                }
            }catch(Exception e1){
                System.out.println(e1);
            }
        }
    }
    

    // Question 2: Read Integers from the Log File.
   
    public static int[] intReader(String filename) {
        /*
         * Write a method that reads all integers from the log file 
         * you created in the previous Question 1.
         * Your method must handle FileNotFoundException and 
         * InputMismatchException exceptions. 
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target log file.
         * Returns:
         *      int[]: Integer Array that stores the integers in the
         *          log file.
         */

         // Your code goes here...
        File file = new File(filename);
        
        int count = 0;
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                fileReader.next();
                count++;
            }
            fileReader.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        int[] integers = new int[count];
        try{
           
            Scanner fileReader2 = new Scanner(file);
            int i = 0;
            while(fileReader2.hasNext()){
                integers[i] = fileReader2.nextInt();
                i++;
            }
            fileReader2.close();
                     
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(InputMismatchException e ){
            System.out.println(e);
        }
          return integers;
    }
    
    // Question 3: Replace Specific Numbers in the Log File
    public static void replaceNumbers(String filename,String filename2, int oldNum, int newNum) {
        /*
         * Write a method that replaces the numbers in the log file
         * you created in Question 1.
         * Your method must handle FileNotFoundException
         * Exception handling message should take only one line in console.
         * Your method must replace the exact numbers into the new number.
         * Example: oldNum=100 newNum=255: All 100s will replaced with
         *  255 but 1000s stays same. (1000 should not be replaced to 2550)
         * 
         * Args:
         *      filename: String that specifies the target log file.
         *      oldNum: The Number to be replaced in the log file.
         *      newNum: The Number to be replaced in the log file.
         */

         // Your code goes here...
        int[] integers = intReader(filename);
        for(int i = 0; i < integers.length; i++){
            if(integers[i] == oldNum)
                integers[i] = newNum;
        }
        try {
            PrintWriter writer = new PrintWriter(filename2);
            for(int i = 0; i < integers.length; i++){
                writer.print(integers[i]+" ");
            }
            writer.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }

    /*
     * Example Pokémon Data:
Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed
Bulbasaur Grass Poison 45 49 49 65 65 45
Ivysaur Grass Poison 60 62 63 80 80 60
Venusaur Grass Poison 80 82 83 100 100 80
Charmander Fire null 39 52 43 60 50 65
Charmeleon Fire null 58 64 58 80 65 80
Charizard Fire Flying 78 84 78 109 85 100
Squirtle Water null 44 48 65 50 64 43
Wartortle Water null 59 63 80 65 80 58
Blastoise Water null 79 83 100 85 105 78
Caterpie Bug null 45 30 35 20 20 45
Metapod Bug null 50 20 55 25 25 30
Butterfree Bug Flying 60 45 50 90 80 70
Weedle Bug Poison 40 35 30 20 20 50
Kakuna Bug Poison 45 25 50 25 25 35
Beedrill Bug Poison 65 90 40 45 80 75
Pidgey Flying Normal 40 45 40 35 35 56
     */

    // Question 4: Read and Sort Pokémon Stats Data 
    public static void readSortPokeStats(String datafile, String sortedfile) {
        /*
         * Write a method that reads pokemon data from a file and sort pokémons
         *  by their total base stats in descending order and writes the sorted
         *  data on a new file in the same format.
         * Data Header in the file is: "Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed"
         * Your method must handle FileNotFoundException
         * Exception handling message should take only one line in console.
         * 
         * 
         * Args:
         *      datafile: String that specifies the target data file.
         *      sortedfile: String that specifies the new data file that 
         *          will contain the sorted data.
         * 
         */

         // Your code goes here...
         try {
            File file = new File(datafile);
            Scanner fileReader = new Scanner(file);
            int linenumber = countCategory(datafile);
            fileReader.nextLine();
            String[][] strings = new String[linenumber-1][3];
            int[][] datas = new int[linenumber-1][6];
            for(int i = 0; i < linenumber-1 ; i++){
                for(int j = 0; j < 3 ; j++){
                    strings[i][j] = fileReader.next();
                }
                for(int j = 0; j < 6 ; j++){
                    datas[i][j] = fileReader.nextInt();
                }                
            }
            int[] sum = new int[datas.length];
            
            for(int i = 0; i < datas.length ; i++){
                for(int j = 0 ; j < datas[0].length;j++){
                    sum[i] += datas[i][j];
                }
            }
            // şu ana kadar pokemonların isimlerini ve statlarını arraylarde deopaladık
            for(int i = 0; i <linenumber-1 ;i++){
                for(int j = 0;j < sum.length-1;j++){
                    if(sum[j] < sum[j+1]){
                        swap(sum, j, j+1);
                        swap2D(strings, j, j+1);
                        swap2D(datas, j, j+1);
                    }
                }
            }
            File outputFile = new File(sortedfile);
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println("Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed");
            for(int i = 0; i<linenumber-1;i++){
                for(int j = 0; j < 9;j++){
                    if(j < 3)
                        writer.print(strings[i][j]+ " ");
                    else    
                        writer.print(datas[i][j-3] + " ");    
                }
                writer.println();
            }
            writer.close();
         } catch (Exception e) {
            System.out.println(e);
         }
    }

    // Question 5: Read and Filter Pokémon Stats Data by Type
    public static String[] readFilterPokeType(String filename, String poketype) {
        /*
         * Write a method that reads pokemon data from a file and filters
         *  the pokémons with the specified type and returns the names
         *  of the pokémons with specified types as String Array
         * Example: For the data above, poketype="Flying": the output 
         *  should be ["Charizard", "Butterfree", "Pidgey"]
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target data file.
         *      poketype: String that represents the target Pokémon type.
         *          (Do not print a message for non-existant Pokémon types
         *          just return an empty string array in that case.)
         * 
         * Returns:
         *      String[]: String that contains the Pokémon names of the specified type.
         * 
         */

         // Your code goes here...
         String[] pokemons2 ={} ;
         try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            fileReader.nextLine();
            int count = 0;
             
            for(int i = 0; i < countCategory(filename)-1;i++){
                String name = fileReader.next();
                fileReader.next();
                String pokeType= fileReader.next();
                if(pokeType.equals(poketype)){
                    count++;
                }
                fileReader.nextLine();
            }
            String[] pokemons = new String[count];
            fileReader = new Scanner(file);
            fileReader.nextLine();
            int reminder = 0;
            for(int i = 0; i < countCategory(filename)-1;i++){
                String name = fileReader.next();
                fileReader.next();
                String pokeType= fileReader.next();
                if(pokeType.equals(poketype)){
                    pokemons[reminder] = name;
                    reminder++;
                }
                fileReader.nextLine();
            }
            pokemons2 = pokemons;
            
         } catch (Exception e) {
            System.out.println(e);
         }
         return pokemons2;
    }

    // Question 6: Read and Filter Pokémon Stats Data by Highest Speed Stat
    public static void readFilterPokeStats(String filename) {
        /*
         * Write a method that reads pokemon data from a file and filters
         *  and prints the 5 pokémons with the highest Speed stat along
         *  with the data header to the console.
         * Print them with their stats without sorting.
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target data file.
         * 
         */

         // Your code goes here...
         int[] speed = new int[5];
         try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            fileReader.nextLine();
            for(int j = 0; j < countCategory(filename)-1; j++){
                for(int i = 0; i<8;i++){
                    fileReader.next();
                }
                int tempSpeed = fileReader.nextInt();
                for(int i = 0; i < 5; i++){
                    if(tempSpeed > speed[i]){
                        speed[i] = tempSpeed;
                        break;
                    }
            }
            }
            for (int i : speed) {
                System.out.println(i);
            }
            
            
         } catch (Exception e) {
            System.out.println(e);
         }
    }

    /////////////// HELPER METHODS ////////////////////////////
    public static int  countCategory(String fileName){
        File file = new File(fileName);
        int count = 0;
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                scan.nextLine();
                count++;
            }
            scan.close();
        }catch(Exception e ){
            System.out.println(e+":  71" +fileName);
        }
        return count;
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void swap2D(int[][] array, int i , int j){
        int temp[] = array[i];
        array[i] = array[j];
        array[j] = temp;
    }public static void swap2D(String[][] array, int i , int j){
        String temp[] = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }
    public static void display(String[] array) {
        for (String i : array) {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }


    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
