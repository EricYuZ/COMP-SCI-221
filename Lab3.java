import java.util.Scanner;

public class Lab3{
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int lena, lenb, lenc;
        System.out.print("Enter the three sides of a triangle: ");
        lena = input.nextInt();
        lenb = input.nextInt();
        lenc = input.nextInt();
        double s,area,area1;
        if ((lena !=0)&& (lenb !=0) && (lenc !=0)&&(lena + lenb >lenc)){
            if ((lena == lenb) && (lena == lenc) && (lenb == lenc)){
                System.out.println("That is an equilateral triangle.");
            }
            else if ((lena == lenb) || (lena == lenc) || (lenb == lenc)){
                System.out.println("That is an isosceles triangle.");}
            else System.out.println("That is a scalene triangle.");
            s = (double)(lena + lenb + lenc)/2.0;
            area = s * (s - lena) * (s - lenb) * (s - lenc);
            area1 = (((int)(Math.sqrt(area)*100))/100.0);
            System.out.println("Its area is: "+area1);
        }
        else System.out.println("That is not a valid triangle.");
    }
}