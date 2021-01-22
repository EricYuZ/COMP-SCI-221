import java.util.Scanner;
public class Lab2 {
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        double pi1 = 0,
               piFinal;
        double num = 1;
        int signal = 1;
        int i,
            numUser;
        for (i = 0; i < 5000; ++i) {
            pi1 = pi1 + 1/num*signal;
            num = num + 2;
            signal = signal * -1;
        }
        piFinal = 4 * pi1;
        System.out.println(piFinal);
        System.out.print("Which digit past the decimal point do you want?");
        Scanner Scnr = new Scanner(System.in);
        numUser = Scnr.nextInt();
        String StringPi = ""+piFinal;
        String part = StringPi.substring(numUser+1,numUser+2);
        System.out.println(part);
    }
}