import java.util.Scanner;

public class Lab5 {
    public static void main(String args[]) { 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two non-negative integers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int temp,i,
            sum = 0;
        boolean flag = true;
        if ((num1 < 0)||(num2 < 0)){
            System.out.println("Non-negative integers are required.");
            flag = false;
        }
        if ((num1 > num2)&&(flag)){ 
            temp = num1; num1 = num2; num2 = temp;
        }
        if (flag){
            for (i=num1; i<num2+1; i++){
                int userVal = i;
                while (userVal > 0) {
                    int digit = userVal % 10;
                    sum = sum + digit;
                    userVal = userVal / 10;
                }
            }
            System.out.println("Sum of all the digits: "+sum);
        }
    }
}


