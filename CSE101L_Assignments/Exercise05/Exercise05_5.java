/*
 * Exercise05_5
 * (Statistics: compute mean and standard deviation) 
 * Yahya Efe Kurucay
 * 18.11.2023 / Sosyal Tesis Ahmet Hamdi Akseki Yurdu
 */

import java.util.Scanner;

public class Exercise05_5 {

public static void displayStatics(int n){
//The parameter n is number of data.
    double totalData=0.0;
    double totalDataSquare=0.0;
    Scanner scanner = new Scanner(System.in);
    for (int i=1;i<=n;i++){

    System.out.print("Enter "+i+". data: ");
    double dataN=scanner.nextDouble();

    totalData+=dataN;
    totalDataSquare+=dataN*dataN;//xsqr + ysqr + zsqr
    }

//Calculate and Display the Mean
double mean= totalData/n;
System.out.print("The Mean: ");
System.out.printf("%.3f", mean);

//Calculate and Display Standart Deviation
double totalDataSqr=totalData*totalData; // (x+y+z)sqr
double devup=(totalDataSquare-(totalDataSqr/n));
double devdown=(n-1);
double devbeforeroot=devup/devdown;
double deviation=Math.sqrt(devbeforeroot);

System.out.print(", Standart Deviation: ");
System.out.printf("%.5f", deviation);
    scanner.close();
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Number of Data: ");
    displayStatics(scanner.nextInt());


    scanner.close();

}



    
}
