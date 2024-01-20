import java.util.Random;

/**
 * Ex1 Yahya Efe Kurucay 16.11.2023
 *1.Write a method random that generates a number between 0-10 and displays it.
 */
public class Ex1 {

    public static void random(){

        Random rand = new Random();
       int integer=rand.nextInt(10);
        

        System.out.println(integer);
        return ;
    }
    public static void main(String[] args) {
        random();
    }

/*2. Instead of printing the number generated, 
 *return the random number generated.
 1- change 'void' to int
 2- move  'System.out.println(integer);' to main method.
 */

}