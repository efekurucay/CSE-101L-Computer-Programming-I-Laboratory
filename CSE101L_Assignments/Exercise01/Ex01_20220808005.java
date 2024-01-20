/*
*-----------------------------------------------------
* Akdeniz University CSE101L Lab Assignments
* Name: Yahya Efe Kurucay
* Date: 13.11.2023
* Description: Exercise01
* Score: 100
* Website: https://efekurucay.com
*-----------------------------------------------------
 */
public class Ex01_20220808005 {
    public static void main(String[] args) {

        //EXERCISE 1 
        System.out.println("ex1");
        System.out.println("a \t a^2 \t a^3");
		System.out.println("1 \t 1 \t 1");
		System.out.println("2 \t 8 \t 4");
		System.out.println("3 \t 9 \t 27");
		System.out.println("4 \t 16 \t 64");

        //EXERCISE 2 
        System.out.println("ex2");
        double a =(9.5*4.5 )-(2.5*3) ;
        double b = (45.5)- (3.5);
        System.out.println(a/b);

        //EXERCISE 3
        System.out.println("ex3");
        double pi = (4)*((1)- (1.0/3) + (1.0/5) -(1.0/7) + (1.0/9) - (1.0/11));
		System.out.println("pi= "+ pi);
		double pi_ = 4*((1)- (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11) + (1.0/13));
		System.out.println("pi_= " + pi_);

        //EXERCISE 4
        System.out.println("ex4");
        double radius= 5.5;
        double area = pi_*radius*radius;
		System.out.println("area = " + area);
	    double perimeter = 2*pi_*radius;
	    System.out.println("perimeter = " + perimeter);

        //EXERCISE 5
        System.out.println("ex5");
        double x = ((44.5*0.55) - (50.2*5.9))/((3.4*0.55 - 50.2*2.1));
		double y = ((3.4*5.9) - (44.5*2.1)) / ((3.4*0.55) - (50.2*2.1));
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		double e = (3.4*x + 50.2*y);
        double f = (2.1*x + 0.55*y);
		System.out.println("e :"+e);
        System.out.println("f :"+f);
       


        }
    }


