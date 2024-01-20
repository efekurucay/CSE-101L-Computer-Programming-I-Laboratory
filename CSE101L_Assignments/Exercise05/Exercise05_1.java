import java.util.Scanner;

/**
 * Exercise05_1 ComputePI METHOD
 * Yahya Efe Kurucay
 * 18.11.2023 / Sosyal Tesis Ahmet Hamdi Akseki Yurdu
 */
public class Exercise05_1 {
public static double computePI(int pi){
double terim=0.0;
if(pi == 0 ){return 3;}
else {

     for (int i=1;i<=pi;i++){
   double pay=Math.pow(-1, (i+1));
   double payda = (2*i -1.0);
    terim+= pay/payda;
    } 
    return terim*4;}
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number to decide sensivity to calculate pi.");
    int numofsense = scanner.nextInt();
    System.out.println(computePI(numofsense));
    scanner.close();
   
}


  
}