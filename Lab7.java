import java.util.Scanner;
public class Lab7 {
    public static void numberjudge(int num1,int num2,int num3){
        boolean flag = false;
        int num4 = num1 + num2;
        int num5 = num1 + num3;
        int num6 = num2 + num3;
        int num7 = num1 + num2 + num3;
        if ((num1 > 0) && (num2 > 0) && (num3 > 0)){
            flag = true;
            if (primejudge(num1)){
                System.out.println(num1 + " is prime.");
            }
            if (primejudge(num2)){
                System.out.println(num2 + " is prime.");
            }
            if (primejudge(num3)){
                System.out.println(num3 + " is prime.");
            }
            if (primejudge(num4)){
                System.out.println(num1 + " + " + num2 + " = " + num4 + " is prime");
            }
            if (primejudge(num5)){
                System.out.println(num1 + " + " + num3 + " = " + num5 + " is prime");
            }
            if (primejudge(num6)){
                System.out.println(num2 + " + " + num3 + " = " + num6 + " is prime");
            }
            if (primejudge(num7)){
                System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + num7 + " is prime");
            }
        }
    }
    public static boolean primejudge(int number){
        boolean isprime = true;
        if (number == 1){
            isprime = false;
        }
        for (int i = 2; i < number; i++){
            if(number % i ==0)
	{
		isprime = false;
        }
        }
        return isprime;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter three integers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        numberjudge(num1,num2,num3);
    }
}