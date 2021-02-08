import java.util.Scanner;
/*
 * Computing grade point averages. 
 * @Zeyang Yu
 */
public class Prog2 {    
    public static void Print(int term,double points,int credits,double gpa){
        System.out.println("Summary for term "+term);
        System.out.println("----------------------------------");
        System.out.println(" Term total grade points:    "+points);
        System.out.println("      Term total credits:    "+credits);
        System.out.println("                Term GPA:    "+gpa);
        System.out.println("");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String GradeLine = " ",
        GradeLetter;
        double GradePoint = 0,
        TermTotalPoints = 0,
        GPA = 0,
        GradePointSum = 0,
        CumulativeGPA = 0;
        int position = 1, Credits = 0,
        SumCredits = 0;    
        int term = 0,
        TotalCredits = 0, 
        i;
        int num = input.nextInt();

        while (num != -1){
            term = term + 1;
            for (i = 0; i < num; i++){
                GradeLetter = input.next();
                GradeLetter = GradeLetter.trim();
                Credits = input.nextInt();
                if (GradeLetter.equals("A")){
                    GradePoint = 4.00;
                }
                if (GradeLetter.equals("A-")){
                    GradePoint = 3.67;
                }
                if (GradeLetter.equals("B+")){
                    GradePoint = 3.33;
                }
                if (GradeLetter.equals("B")){
                    GradePoint = 3.00;
                }
                if (GradeLetter.equals("B-")){
                    GradePoint = 2.67;
                }
                if (GradeLetter.equals("C+")){
                    GradePoint = 2.33;
                }
                if (GradeLetter.equals("C")){
                    GradePoint = 2.00;
                }
                if (GradeLetter.equals("C-")){
                    GradePoint = 1.67;
                }
                if (GradeLetter.equals("D+")){
                    GradePoint = 1.33;
                }
                if (GradeLetter.equals("D")){
                    GradePoint = 1.00;
                }
                if (GradeLetter.equals("D-")){
                    GradePoint = 0.67;
                }
                if (GradeLetter.equals("F")){
                    GradePoint = 0.00;
                }
                SumCredits = SumCredits + Credits;
                TermTotalPoints = TermTotalPoints + Credits * GradePoint;
                GPA = GPA + Credits * GradePoint;
            }
            GPA = ((int) ((GPA / SumCredits) * 100)) / 100.0;
            Print(term, TermTotalPoints, SumCredits, GPA);
            TotalCredits = TotalCredits + SumCredits;
            GradePointSum = GradePointSum + TermTotalPoints;
            num = input.nextInt();
            SumCredits = 0;
            TermTotalPoints = 0;
            GPA = 0;
        }
        CumulativeGPA = ((int) ((GradePointSum / TotalCredits) * 100)) / 100.0;
        System.out.println("Final summary");
        System.out.println("----------------------------------");
        System.out.println("           Overall terms:    "+term);
        System.out.println("      Total grade points:    "+GradePointSum);
        System.out.println("           Total credits:    "+TotalCredits);
        System.out.println("          Cumulative GPA:    "+CumulativeGPA);
        System.out.println("");
        System.out.println("Done. Normal termination.");
    }
}
 