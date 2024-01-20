import java.util.Scanner;
/**
 * Exercise05_2 factorial METHOD
 * Yahya Efe Kurucay
 * 18.11.2023 / Sosyal Tesis Ahmet Hamdi Akseki Yurdu
 */
public class Exercise05_2 {
    

public static int factorial(int integer){
int factorial=integer;

if(integer==0){factorial=1;}

else{
    for(int i =integer-1; i>0; i--){

        factorial*=i;
    }
}
return factorial ;}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter an integer to calculate its factorial: ");
int integer = scanner.nextInt();
if(integer<0){System.out.println("ERROR: It cant be less than zero!");}
else{
System.out.println("The factorial of "+integer+" is "+factorial(integer));}

scanner.close();
}

}
