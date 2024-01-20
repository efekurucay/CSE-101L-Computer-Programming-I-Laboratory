import java.util.Scanner;
/*
*-----------------------------------------------------
* Akdeniz University CSE101L Lab Assignments
* Name: Yahya Efe Kurucay
* Date: 14.11.2023
* Description: Exercise02
* Score: 100
* Website: https://efekurucay.com
*-----------------------------------------------------
 */
public class Ex0220220808005 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        //TASK 1 
       System.out.println("Enter an integer to output the second to last digit : ");
       int sayi = input.nextInt();
       if (sayi<10&& sayi>-10){ System.out.println(0);   }
    else {
            int a = (sayi/10)%10 ;
            if(a<0){System.out.println(-a);}
            else{System.out.println(a);}

        }

         //TASK 2 
        System.out.println("Enter the time you use");
        int usemin = input.nextInt();
        if (usemin<=0){System.out.println("You can not use negative time or 0 ");}
        else{
            double useminmod60 = usemin % 60;
        double havetopay = (usemin/60 +1) * 50;
        double didnotuse= havetopay/50*60- usemin;
        System.out.println("You spent "+usemin +" minutes, you have to pay " +havetopay+" TL and you did not use "+didnotuse + " minutes");
        }
        
        //TASK 3

        System.out.print("Enter the number that you will have '4' first :");
        int k = input.nextInt();
if (k<=0){System.out.println("You can not enter negative number or 0 ");}
else  {double probability = Math.pow((5.0/6),(k-1)) / 6.0 ;
        System.out.println("Your probability is "+probability +" to get '4'  on "+k+ " trying");}
        


    }}
