import java.util.Scanner;
public class Lab6 {
    public static void main(String args[]) {
        int[] bigData = new int[999999];
        int sum = 0;
        int num,j,
            i = 0;
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter some numbers (Ctrl-d to quit):");
        while( input.hasNextInt() )
        {
            num =  input.nextInt() ;
            bigData[i] = num;
            i = i + 1;
        }
        input.close();
        for (j = i-1; j >= 0; j--){
            System.out.print(bigData[j]+" ");
        }
    }
}