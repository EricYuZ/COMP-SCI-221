import java.util.Scanner;

public class Lab4 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        line = line.trim();
        boolean flag = false;

        int position1, position2, position3;
        int len = line.length();
        int i,positionInt;
        position1 = line.indexOf('<');
        position2 = line.indexOf('=');
        position3 = line.indexOf('>');
        String sub1,sub2;
        sub1 = line;
        sub2 = line;
        if ((position1 != -1)&&(position2 != -1)) {
            sub1 = line.substring(0,position1);
            sub1 = sub1.trim();
            sub2 = line.substring(position2+1,len);
            sub2 = sub2.trim();
            int subint1 = Integer.parseInt(sub1);
            int subint2 = Integer.parseInt(sub2);
            if (subint1 <= subint2) {
                flag = true;}   
        }
        if ((position1 != -1)&&(position2 == -1)) {
            sub1 = line.substring(0,position1);
            sub1 = sub1.trim();
            sub2 = line.substring(position1+1,len);
            sub2 = sub2.trim();
            int subint1 = Integer.parseInt(sub1);
            int subint2 = Integer.parseInt(sub2);
            if (subint1 < subint2) {
                flag = true;}
        }
        if ((position3 != -1)&&(position2 != -1)) {
            sub1 = line.substring(0,position3);
            sub1 = sub1.trim();
            sub2 = line.substring(position2+1,len);
            sub2 = sub2.trim();
            int subint1 = Integer.parseInt(sub1);
            int subint2 = Integer.parseInt(sub2);
            if (subint1 >= subint2) {
                flag = true;}
        }
        if ((position3 != -1)&&(position2 == -1)) {
            sub1 = line.substring(0,position3);
            sub1 = sub1.trim();
            sub2 = line.substring(position3+1,len);
            sub2 = sub2.trim();
            int subint1 = Integer.parseInt(sub1);
            int subint2 = Integer.parseInt(sub2);
            if (subint1 > subint2) {
                flag = true;}
        }
        String Total;
        Total = "True";
        if (flag==false){
            if ((position1 != -1)&&(position2 != -1)){
                Total= sub1 + ">" + sub2;}
            if ((position1 != -1)&&(position2 == -1)){
                Total= sub1 + ">=" + sub2;}
            if ((position3 != -1)&&(position2 != -1)){
                Total= sub1 + "<" + sub2;}
            if ((position3 != -1)&&(position2 == -1)){
                Total= sub1 + "<=" + sub2;}
        }
        System.out.println(Total);
    }
}   