
import java.util.Scanner;
/**
 * Exercise05_4 Perfect Numbers METHOD
 * Yahya Efe Kurucay
 * 18.11.2023 / Sosyal Tesis Ahmet Hamdi Akseki Yurdu
 */

public class Exercise05_4 {


public static void nPerfectNumbers(int n){

int numOfPerfect=0;
int x=1;
    do{
        //Find the sum of positive divisiors.
        int sumdiv=0;
        for(int i=1;i<x;i++){

            boolean divide= x%i==0;
            if(divide==true){sumdiv+=i;}

        }
        //is Perfect or not
        if(sumdiv==x){
            numOfPerfect++;
            System.out.println(numOfPerfect+". perfect number: "+x);}
        x++;
}while(numOfPerfect<n);
        

}//nPerfectNumbers Method
    
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    nPerfectNumbers(scanner.nextInt());
    scanner.close();
}//Main Method



}//Class
