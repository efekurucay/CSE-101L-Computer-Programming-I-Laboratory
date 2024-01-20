import java.util.Scanner;
/**
 * Exercise05_3 isPRIME METHOD
 * Yahya Efe Kurucay
 * 18.11.2023 / Sosyal Tesis Ahmet Hamdi Akseki Yurdu
 */
public class Exercise05_3 {
    
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//nPrimes > display first n prime number.
  if(isPrime(scanner.nextInt())==true){System.out.println("PRIME");}
  else{System.out.println("not PRIME");}
    nPrimes(8);



    scanner.close();
    }
   
}