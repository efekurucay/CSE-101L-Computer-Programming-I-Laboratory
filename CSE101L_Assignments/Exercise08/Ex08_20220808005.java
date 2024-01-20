import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ex08_20220808005{
    /*
     * Change the X's in the both file name and class' name to your own
     * student number and submit your file to the assignment given through
     * Teams.
     * 
     * if you do NOT submit your assignment in time, you will recieve 0
     * if your file has compile time errors, and do not compile you will recieve 10
     * if your file does compile but a runtime error occurs, you will recieve 20
     * You MUST NOT change the method headers and comply with their return types
     * 
     * Main method is just there for you to test your program, you will not be evaluated by your main method
     * You can write any method you like, and use them in suitable places but you will only be graded
     * for your work for the questions
     * 
     *-----------------------------------------------------
     * Akdeniz University CSE101L Lab Assignments
     * Name: Yahya Efe Kurucay
     * Date: 01.01.2024 
     * Description: Exercise08
     * Website: https://efekurucay.com
     * !!!!!!!!! FULL CHATGPT.!!!! I DID NOT REVIEW I DON NOT KNOW IF IT IS WORKING OR NOT
     * !!!!!!!!! LOOK AT THE OTHER FILE THAT FINISH WITH 037. THANKS TO BURAK 
     *-----------------------------------------------------
     */
     public static void main(String[] args) {
        // Test the intLogger method
        intLogger("IntegerLog.txt");

        // Test the intReader method
        int[] intArray = intReader("IntegerLog.txt");
        System.out.println("Logged Integers: " + Arrays.toString(intArray));

        // Test the replaceNumbers method
        replaceNumbers("IntegerLog.txt", 5, 10);

        // Test the readSortPokeStats method
        readSortPokeStats("PokeStats.txt", "SortedPokeStats.txt");

        // Test the readFilterPokeType method
        String[] flyingPokemon = readFilterPokeType("PokeStats.txt", "Flying");
        System.out.println("Pokémon with Flying type: " + Arrays.toString(flyingPokemon));

        // Test the readFilterPokeStats method
        readFilterPokeStats("PokeStats.txt");
    }

    // Question 1: Log unspecified number of integers * chatgpt
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
         try (Scanner scanner = new Scanner(System.in);
         PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

        while (true) {
            try {
                System.out.print("Enter an integer (or 0 to exit): ");
                int input = scanner.nextInt();

                // Log the input to the console
                System.out.println(input);

                // If input is 0, exit the loop
                if (input == 0) {
                    break;
                }

                // Log the input to the file
                writer.println(input);

            } catch (InputMismatchException e) {
                // Log non-integer input to the console
                System.out.println("non-integer-input");

                // Log non-integer input to the file
                writer.println("non-integer-input");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }

    } catch (IOException e) {
        // Log the exception message to the console
        System.out.println("Exception: " + e.getMessage());
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
         int[] integers = new int[0];
        int index = 0;

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                try {
                    int value = fileScanner.nextInt();

                    // Resize the array and add the new value
                    int[] tempArray = new int[index + 1];
                    System.arraycopy(integers, 0, tempArray, 0, index);
                    tempArray[index] = value;
                    integers = tempArray;
                    index++;
                } catch (Exception e) {
                    // Log non-integer input to the console
                    System.out.println("non-integer-input");
                    // Consume the invalid input to prevent an infinite loop
                    fileScanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            // Log file not found exception to the console
            System.out.println("File not found: " + filename);
        }

        return integers;
    }

    // Question 3: Replace Specific Numbers in the Log File
    public static void replaceNumbers(String filename, int oldNum, int newNum) {
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

         try (Scanner fileScanner = new Scanner(new File(filename));
         PrintWriter writer = new PrintWriter(new FileWriter("temp.txt"))) {

        while (fileScanner.hasNext()) {
            try {
                int value = fileScanner.nextInt();

                // Replace oldNum with newNum
                if (value == oldNum) {
                    writer.print(newNum + " ");
                } else {
                    writer.print(value + " ");
                }
            } catch (Exception e) {
                // Log non-integer input to the console
                System.out.println("non-integer-input");
                // Consume the invalid input to prevent an infinite loop
                fileScanner.next();
            }
        }

    } catch (IOException e) {
        // Log file not found exception to the console
        System.out.println("Exception: " + e.getMessage());
    }

    // Rename temp file to the original file
    File originalFile = new File(filename);
    File tempFile = new File("temp.txt");

    if (tempFile.renameTo(originalFile)) {
        System.out.println("Numbers replaced successfully.");
    } else {
        System.out.println("Error replacing numbers.");
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
        try (Scanner fileScanner = new Scanner(new File(datafile));
             PrintWriter writer = new PrintWriter(new FileWriter(sortedfile))) {

            // Read the header line (discard it for now)
            fileScanner.nextLine();

            // Read and store Pokemon data in an array
            String[] pokemonData = new String[0];
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                pokemonData = addElementToArray(pokemonData, line);
            }

            // Sort Pokemon data by total base stats in descending order
            sortPokemonData(pokemonData);

            // Write sorted data to the new file
            writer.println("Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed");
            for (String line : pokemonData) {
                writer.println(line);
            }

            System.out.println("Pokémon data sorted and written to " + sortedfile);
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static String[] addElementToArray(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private static void sortPokemonData(String[] pokemonData) {
        for (int i = 0; i < pokemonData.length - 1; i++) {
            for (int j = i + 1; j < pokemonData.length; j++) {
                if (compareTotalBaseStats(pokemonData[j], pokemonData[i]) > 0) {
                    // Swap lines if jth Pokemon has higher total base stats than ith Pokemon
                    String temp = pokemonData[i];
                    pokemonData[i] = pokemonData[j];
                    pokemonData[j] = temp;
                }
            }
        }
    }

    private static int compareTotalBaseStats(String line1, String line2) {
        int totalStats1 = extractTotalBaseStats(line1);
        int totalStats2 = extractTotalBaseStats(line2);
        return Integer.compare(totalStats2, totalStats1);
    }

    private static int extractTotalBaseStats(String line) {
        String[] data = line.split(" ");
        int total = 0;
        for (int i = 3; i < data.length; i++) {
            total += Integer.parseInt(data[i]);
        }
        return total;
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
         String[] filteredPokemonNames = new String[0];

         try (Scanner fileScanner = new Scanner(new File(filename))) {
             // Read the header line (discard it for now)
             fileScanner.nextLine();
 
             while (fileScanner.hasNextLine()) {
                 String line = fileScanner.nextLine();
                 if (line.contains(poketype)) {
                     String[] data = line.split(" ");
                     String pokemonName = data[0];
                     filteredPokemonNames = addElementToArray(filteredPokemonNames, pokemonName);
                 }
             }
         } catch (FileNotFoundException e) {
             System.out.println("Exception: " + e.getMessage());
         }
 
         return filteredPokemonNames;
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
         try {
            // Dosyayı okuma
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // Başlık satırını okuma
            String header = reader.readLine();

            // Pokemon verilerini depolamak için liste oluşturma
            List<String[]> pokemonData = new ArrayList<>();

            // Dosyadaki her satırı okuma ve listeye ekleme
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                pokemonData.add(data);
            }

            // Hız istatistiğine göre sıralama
            pokemonData.sort(Comparator.comparingInt(data -> Integer.parseInt(data[6])));

            // En yüksek 5 Hız istatistiğine sahip Pokemon'ları yazdırma
            System.out.println(header);
            for (int i = Math.max(0, pokemonData.size() - 5); i < pokemonData.size(); i++) {
                String[] data = pokemonData.get(i);
                System.out.println(String.join(" ", data));
            }

            // Dosyayı kapatma
            reader.close();
        } catch (IOException e) {
            // İstisna durumu: Dosya okuma hatası
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        } catch (NumberFormatException e) {
            // İstisna durumu: Hız istatistiği sayıya dönüştürülemez
            System.out.println("Hata: Hiz istatistiği sayiya dönüştürülemedi.");
        }
         
    }

    /////////////// HELPER METHODS ////////////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
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