import java.util.Scanner;

/**
 * Ex04_20220808005
 */
public class Ex04_20220808005 {

    public static void main(String[] args) {
        
Scanner scanners = new Scanner(System.in);
Scanner scanneri = new Scanner(System.in);

//TASK 1 

        System.out.println("enter center coordinates ");

        // center coordinates 
        int x1 = scanneri.nextInt();
        int y1= scanneri.nextInt();

        System.out.println("enter a point on the circles edge");
        int x2 =scanneri.nextInt();
        int y2 =scanneri.nextInt();

        double radiussq = (y2-y1)*(y2-y1) + (x2-x1)*(x2-x1);
        double radius = Math.sqrt(radiussq);

        double circumference = 2*radius*Math.PI; 
        double area = Math.PI*radius*radius;
        System.out.println("area and circumference : "+ area+", "+circumference);


// TASK 2
System.out.println("Enter your name and surname");
	
		String fullname =scanners.nextLine();
		int bosluk =fullname.indexOf(' ');
		String name=fullname.substring(0,bosluk);
		String surname=fullname.substring(bosluk+1);
	    System.out.println(surname+", "+name);

//TASK 3
        
System.out.println("Enter a number for a day");


int day = scanneri.nextInt();
String dayString = " 7";

switch (day) {
    case 1:
        dayString="Monday";
        break;
    case 2:
        dayString="Tuesday";
        break;
    case 3:
        dayString="Wednesday";
        break;
    case 4:
        dayString="Thursday";
        break;

    case 5:
        dayString="Friday";
        break;
    case 6:
        dayString="Saturday";
        break;
    case 7:
        dayString="Sunday";
        break;
    default:
    System.out.print("Your input must be a number between 1 and");
        break;


}

        System.out.println(dayString);

//TASK 4 
System.out.println("Enter 3 city");

String city1 = scanners.nextLine();
String city2 = scanners.nextLine();
String city3 = scanners.nextLine();

char city1_ = city1.charAt(0);
char city2_ = city2.charAt(0);
char city3_ = city3.charAt(0);

int i = city1_;
int i2 = city2_;
int i3 = city3_;


if (i==i2 || i3==i ||i2==i3){System.out.println("INVALID INPUT");}
else{
    //1,2,3
if (i<i2 && i2<i3) { System.out.println(city1 +", " + city2+ ", "+ city3);}
//1,3,2
if (i<i3 && i3<i2) {System.out.println(city1 +", " + city3+ ", "+ city2);}
//2,1,3
if (i2<i && i<i3) {System.out.println(city2 +", " + city1+ ", "+ city3);}
//2,3,1
if (i2<i3 && i3<i) {System.out.println(city2 +", " + city3+ ", "+ city1);}
//3,1,2
if (i3<i && i<i2) {System.out.println(city3 +", " + city1+ ", "+ city2);}
//3,2,1
if (i3<i2 && i2<i) {System.out.println(city3 +", " + city2+ ", "+ city1);}
}

//TASK 5



    System.out.println("Enter height of triangle");
    double height = scanneri.nextDouble();
    System.out.println("Enter base of triangle");
    double base =scanneri.nextDouble();
    

    double area0 = (height*base)/2.0;

    System.out.printf("Area: %.3f",area0);


















    }
}