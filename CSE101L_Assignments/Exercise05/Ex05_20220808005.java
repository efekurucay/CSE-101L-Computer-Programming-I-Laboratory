import java.util.Scanner;
/*
*-----------------------------------------------------
* Akdeniz University CSE101L Lab Assignments
* Name: Yahya Efe Kurucay
* Date: 26.12.2023
* Description: Exercise05
* Score: 82
* Website: https://efekurucay.com
*-----------------------------------------------------
 */
public class Ex05_20220808005 {

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

     public static int factorial(int integer){
        int factorial=integer;
            
        if(integer==0){factorial=1;}
            
           else{
              for(int i =integer-1; i>0; i--){
            
                   factorial*=i;
            }
          }
          return factorial ;}

          public static boolean isPrime(int prime){ 

        
            boolean isprime=false;
            boolean control;
            int i =2;
            do{
            control =prime%i!= 0;
            i++;
            if(control==false){isprime=true;}
            else{}
            }
            while(control&& i<prime);
    
           if(prime ==2){isprime=false;}
           else if (prime<2){isprime=true;}
           else{}
    
          if(isprime==true){return false;}
          else{return true;}
         
        }
        
        public static void nPrimes(int n){
    int x=1;
    int numOfPrime=0;
        do{ 
    
             if(isPrime(x)==true){numOfPrime++;
            System.out.println(numOfPrime+". prime number: "+x);}
            x++;    
            }
            while(numOfPrime<n);
    
        }

 public static void nPerfectNumbers(int n){

int numOfPerfect=0;
int x=1;
    do{
       
        int sumdiv=0;
        for(int i=1;i<x;i++){

            boolean divide= x%i==0;
            if(divide==true){sumdiv+=i;}

        }
       
        if(sumdiv==x){
            numOfPerfect++;
            System.out.println(numOfPerfect+". perfect number: "+x);}
        x++;
}while(numOfPerfect<n);
        

} 
public static void displayStatistics(int n){

    double totalData=0.0;
    double totalDataSquare=0.0;
    Scanner scanner = new Scanner(System.in);
    for (int i=1;i<=n;i++){

    System.out.print("Enter "+i+". data: ");
    double dataN=scanner.nextDouble();

    totalData+=dataN;
    totalDataSquare+=dataN*dataN;
    }


double mean= totalData/n;
System.out.print("The Mean: ");
System.out.printf("%.3f", mean);


double totalDataSqr=totalData*totalData;
double devup=(totalDataSquare-(totalDataSqr/n));
double devdown=(n-1);
double devbeforeroot=devup/devdown;
double deviation=Math.sqrt(devbeforeroot);

System.out.print(", Standart Deviation: ");
System.out.printf("%.5f", deviation);
    scanner.close();
}

    



    
}
