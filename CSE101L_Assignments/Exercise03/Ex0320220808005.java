import java.util.Random;
import java.util.Scanner;
/*
*-----------------------------------------------------
* Akdeniz University CSE101L Lab Assignments
* Name: Yahya Efe Kurucay
* Date: 14.11.2023
* Description: Exercise03
* Score: 46 (due to Ş I guess)
* Website: https://efekurucay.com
*-----------------------------------------------------
 */
public class Ex0320220808005{

public static void main(String[] args) {
Scanner efe = new Scanner(System.in);

//TASK 1
//MENU INFO
System.out.println("ID    MEAL      PRICE");
System.out.println("1     DONER     80 LIRA");
System.out.println("2     KEBAP     110 LIRA");
System.out.println("3     LAHMACUN  75 LIRA");
System.out.println("............................");
System.out.println("ID    DRINK     PRICE");
System.out.println("1     AYRAN     10 LIRA");
System.out.println("2     KOLA      20 LIRA");
System.out.println("3     ŞALGAM    15 LIRA");
System.out.println("ENTER ID FOR MEAL AND DRINK");
//VALUES
String mealS="ERROR";
String drinkS="ERROR";
int mealprice=0;
int drinkprice=0;
int meal = efe.nextInt();
int drink=efe.nextInt();
//CONTROL WHICH MEAL
switch (meal) {
  case 1:
    mealS="Döner";
    mealprice=80;
    break;
  case 2:
    mealS="Kebap";
    mealprice=110;
    break;
  case 3:
    mealS="Lahmacun";
    mealprice=75;
    break;
  default:
   System.out.println("Please enter 1, 2 or 3");
    break;
}
//CONTROL WHICH DRINK
switch (drink) {
  case 1:
    drinkS="Ayran";
    drinkprice=10;
    break;
  case 2:
    drinkS="Kola";
    drinkprice=20;
    break;
  case 3:
    drinkS="Şalgam";
    drinkprice=15;
    break;
  default:
    System.out.println("Please enter 1, 2 or 3");
    break;
}
//OUTPUT
int totalmenuprice=mealprice+drinkprice;
// 1 3 aralığında olmalı 5 yazınca da yazdırıyor error diye onu yap.
System.out.println(mealS+" and "+drinkS+" "+totalmenuprice+" lira");

//TASK2

System.out.println("Enter your type of membership and the internet you use");
int type =efe.nextInt();
int gbuses=efe.nextInt();
int quota;
double priceforpergb;
double totalprice;
//negatif kontrolunu yap gb ın
if(type==1){
   quota=100;
    priceforpergb=3.0 *(115.0/100);
   totalprice=80.0+ ((gbuses-quota)*priceforpergb);
   System.out.println("TOTAL AMOUNT : "+ totalprice);

}
else if (type==2){
  quota=200;
    priceforpergb=5.0*(110.0/100);
     totalprice=140 + ((gbuses-quota)*priceforpergb);
     System.out.println("TOTAL AMOUNT : "+ totalprice);

}
else{System.out.println("The type of membership must be 1 or 2");}






//TASK3



        
Random random = new Random();
int damage= 0;
System.out.print("Enter attack number: ");
int attack = efe.nextInt();

//attack 1
if (attack==1) {
    
System.out.print("Heads or tails? (0 for tails, 1 for heads, 2 for luck)");
int coin1 = efe.nextInt();
System.out.print("Heads or tails? (0 for tails, 1 for heads, 2 for luck)");
int coin2 = efe.nextInt();
if(coin1==2){coin1 = (int) (Math.random() * 2);}
if(coin1==2){coin1 = (int) (Math.random() * 2);}
if((coin1>2 || coin1 <0 )||(coin2>2 || coin2 <0 )){System.out.println("You must enter 0,1 or 2");}
else{
    if (coin1==1 && coin2==1){
    damage=60;
}
else{damage=0;}

}
}


//attack 2



else if (attack==2) {
  
System.out.print("Heads or tails? (0 for tails, 1 for heads, 2 for luck)");
int coin1 = efe.nextInt();
System.out.print("Heads or tails? (0 for tails, 1 for heads, 2 for luck)");
int coin2 = efe.nextInt();
if(coin1==2){coin1 = (int) (Math.random() * 2);}
if(coin1==2){coin1 = (int) (Math.random() * 2);}

if((coin1>2 || coin1 <0 )||(coin2>2 || coin2 <0 )){System.out.println("You must enter 0,1 or 2");}
else{damage = 50;
if(coin1==1 && coin2==1){damage+=40;}
else if ((coin1==1&& coin2!=1)|| (coin2==1&& coin1!=1)){damage+=20;}
else {}}

}
else{System.out.println("You must use a number 1 or 2 for attack.");}


System.out.println("Total Damage: "+damage);

























}


































































































}



















