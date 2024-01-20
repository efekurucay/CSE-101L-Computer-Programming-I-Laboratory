import java.util.Random;
/*
 * 3. Write a method random that 
 * generates a number between given min and max.
 */

public class Ex3 {
     public static int random(int min, int max){

        Random rand = new Random();
        
       double integer=min+rand.nextDouble(1)*(max-min);
        int integerint=(int)integer;

      
        return integerint;
    }
    public static void main(String[] args) {
        int min=0;
        int max=10;
        System.out.println(random(min,max));
        
          
         
    }

/*
 * 4. Write a method random that generates a 
 * char between given start and end chars. Can you write 
 * a random method that doesn’t takes any parameters and 
 * returns a char while previous methods exists?
 */
    public static void random(){
    int minchar = random(0, 0);
    int maxchar =random(0,0);
    char a=5;


    }
    
}
