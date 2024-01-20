import java.util.Random;

/**
*-----------------------------------------------------
* Akdeniz University CSE101L Lab Quiz 1 (Midterm)
* Name: Yahya Efe Kurucay
* Date: 20.11.2023
* Description: Quiz1
* Score: ?
* Website:  https://efekurucay.com
*-----------------------------------------------------
 */
public class Quiz1_20220808005 {

    public static String generatePalindrome(int n) {
        if (n <= 0) {
          System.out.println("Length must be positive");
        }
      
        String firstHalf = "";
        Random random = new Random();
      
    
    for (int i = 0; i < n / 2; i++) {
          char randomCharacter = (char) (random.nextInt(26) + 'a');
          firstHalf += randomCharacter;
        }
      
        String secondHalf=reverse(firstHalf);
      
        return firstHalf + secondHalf;
      }
      

    public static String reverse(String text){
        String reversed="";

        for(int i=  text.length()-1; i >= 0;i--){
            char a= text.charAt(i);

            reversed +=a;

        }

        return reversed;
    }



    public static boolean isPalindrome(String text){

        return true;
    }

public static void compareNames(String name1, String name2) {
if (name1.length() == name2.length()) {
if (name1.equals(name2)) {
System.out.println("The names are the same.");
} else {
char ikidensona = name1.charAt(name1.length() - 2);
System.out.println("the second to last character of first string: " + ikidensona);
}
} else {
 if (name1.contains(name2)) {
  String aa= name1.replaceAll("[" + name2 + "]", "").toUpperCase();
 System.out.println("characters in uppercase: " + aa);
   } else if (name2.contains(name1)) {
 String aa = name2.replaceAll("[" + name1 + "]", "").toUpperCase();
 System.out.println("characters in uppercase: " + aa);
 } else {
String secondNameikidensona = name2.substring(1);
System.out.println("second name from second to last characters: " + secondNameikidensona);
                }
            }
        }

public static void cylinder(int x, int y, int height) {
double radius = Math.sqrt(x * x + y * y);
double surfaceArea = 2 * calculatePI(0)* radius * height + 2 * calculatePI(0) * radius * radius;
double volume = calculatePI(0) * radius * radius * height;
double perimeter = 2 * calculatePI(0)* radius + 2 * height;
      
System.out.println("Surface Area: ");
System.out.printf("%.2f", surfaceArea);

System.out.println("Volume: ");
System.out.printf("%.3f", volume);

System.out.println("Total Perimeter: ");
System.out.printf("%.2f", perimeter);

  }
        
    

public static double calculatePI (int n){
double pi=3;
    if(n>=1){


for(int i=1; i<=n; i++){

    double pay=Math.pow((-1), i+1);
    double payda=(2*i)-1;
    pi += 4* (pay/payda);

}

    }

    else if (n==0){}

    else if (n==-1){pi= Math.PI;}

    else{}


    return pi;
}

public static double distance(int x, int y){

    double distance= Math.pow(y, 2)+ Math.pow(x, 2);
    double finaldistance = Math.sqrt(distance);

    return finaldistance;
}

public static double area(int radius){

    double area = Math.pow(radius,2)*calculatePI(0);
    return area;
}

public static double area(int height, int width){
double area = width*height/2;
    return area;
}

public static double circumference(int radius){

double circumference=2* calculatePI(0)*radius;

    return circumference;
}


public static int perimeter(int width, int height) {
    int perimeter = 2 * (width + height);
    return perimeter;
  }
  

public static boolean isLicensePlateValid(String licensePlate) {
    if (licensePlate == null) {
        return false;
    }
    if (licensePlate.length() != 7) {
        return false;
    }
   
    return true;
}


    public static String weekDay(int daynum){
String day ;
        switch (daynum) {
            case 1:
                day="Monday";
                break;
            case 2:
                day="Tuesday";
                break;
            case 3:
                day="Wednesday";
                break;
            case 4:
                day="Thursday";
                break;
            case 5:
                day="Friday";
                break;
            case 6:
                day="Saturday";
                break;
            case 7:
                day="Sunday";
                break;
            default:
                day="invalid";
                break;
        }
        return day;
    }





}