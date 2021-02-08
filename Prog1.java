import java.util.Scanner;
/*
 * Detering if a given date is valid and if so, prints out the previous date. 
 * @Zeyang Yu
 */
public class Prog1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the month, day and year: ");
        int February = 28;
        int Day, Month, Year;
        boolean flag = true;
        String Result="";
        Month = input.nextInt();
        Day = input.nextInt();
        Year = input.nextInt();
        if (Year % 400 == 0){
            February = February + 1;
        }
        if ((Year % 100 != 0)&&(Year % 4 == 0)){
            February = February + 1;
        }
        if ((Month==1)||(Month==3)||(Month==5)||(Month==7)||(Month==8)||(Month==10)||(Month==12)){
            if ((Day<1) || (Day>31)){
                flag = false;}
        }
        if ((Month==4)||(Month==6)||(Month==9)||(Month==11)){
            if ((Day<1) || (Day>30)){
                flag = false;}
        }
        if (Month==2){
            if ((Day<1) ||(Day>February)){
                flag = false;}
        }
        if (flag==false){
            Result = "Invalid day: "+Day;
        }
        Day = Day -1;
        if ((Day == 0)&&(Month != 3)){
            Month = Month - 1;
            if ((Month==1)||(Month==3)||(Month==5)||(Month==7)||(Month==8)||(Month==10)||(Month==12)){
                Day = 31;
            }
            if ((Month==4)||(Month==6)||(Month==9)||(Month==11)){
                Day = 30;
            }
        }
        if ((flag)&&(February == 29)&&(Month == 3)&&(Day == 0)){
            Day = 29;
            Month = 2;
        }
        if ((flag)&&(February == 28)&&(Month ==3 )&&(Day == 0)){
            Day = 28;
            Month = 2;
        }
        if ((Month == 1)&& (flag)){
            Result = "January";
        }
        if ((Month == 2)&& (flag)){
            Result = "February";
        }
        if ((Month == 3)&& (flag)){
            Result = "March";
        }
        if ((Month == 4)&& (flag)){
            Result = "April";
        }
        if ((Month == 5)&& (flag)){
            Result = "May";
        }
        if ((Month == 6)&& (flag)){
            Result = "June";
        }
        if ((Month == 7)&& (flag)){
            Result = "July";
        }
        if ((Month == 8)&& (flag)){
            Result = "August";
        }
        if ((Month == 9)&& (flag)){
            Result = "September";
        }
        if ((Month == 10)&& (flag)){
            Result = "October";
        }
        if ((Month == 11)&& (flag)){
            Result = "November";
        }
        if ((Month == 12)&& (flag)){
            Result = "December";
        }
        if ((Month == 0)&& (flag)){
            Result = "December";
            Day = 31;
            Year = Year - 1;
        }
        if (flag){
            Result = Result +" "+Day+", "+Year;
        }
        System.out.println(Result);
    }
}