public class Ex7 {
    

    public static int reverse(int number) {
       /*  int reversenum = 0;
        while (number != 0) {
            int lastnum = number % 10; // digit = b
            reversenum = reversenum * 10 + lastnum;
            number /= 10;
        }
        12345
        */
        String numberReversed ="";
        String numberString = Integer.toString(number);
        
        for (int i = numberString.length(); i>0 ; i--){

        numberReversed+=numberString.charAt(i);

        }

        int reversed =  Integer.parseInt(numberReversed);
        return reversed;
    }
    public static void main(String[] args) {
        
        System.out.println(reverse(4567));
    }


}
/*
 * 
 * 
 * 15 , 51     66
 * 
 * 17  71       88
 * 
 * 
 * 111 111     222
 * 
 * 
 * 104  401   505
 * 
 * 
 * 114  411   525
 */