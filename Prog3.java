import java.util.Scanner;
/*
* computes your final course grade, based on a weighted-average 
formula, i.e., an average in which each term is multiplied by a significance factor.
* Zeyang Yu
*/
public class Prog3 {
    public static final double A_MIN = 91.0;
    public static final double A_MINUS_MIN = 89.0;
    public static final double B_PLUS_MIN = 87.0;
    public static final double B_MIN = 81.0;
    public static final double B_MINUS_MIN = 79.0;
    public static final double C_PLUS_MIN = 77.0;
    public static final double C_MIN = 71.0;
    public static final double C_MINUS_MIN = 69.0;
    public static final double D_PLUS_MIN = 67.0;
    public static final double D_MIN = 61.0;
    public static final double D_MINUS_MIN = 55.0;
    public static final double F_MIN = 0.0;
    public static void main(String args[]) {
        Scanner inFromUser = new Scanner(System.in);
        double quizWeight, labWeight, progWeight, examWeight;
        System.out.print("Enter weights (quizzes, labs, programs, exams): ");
        quizWeight = inFromUser.nextDouble();
        labWeight = inFromUser.nextDouble();
        progWeight = inFromUser.nextDouble();
        examWeight = inFromUser.nextDouble();
        
        double quizMax, labMax, progMax, examMax;
        System.out.print("Enter maximum scores (quizzes, labs, programs, exams): ");
        quizMax = inFromUser.nextDouble();
        labMax = inFromUser.nextDouble();
        progMax = inFromUser.nextDouble();
        examMax = inFromUser.nextDouble();
        System.out.println();
        double[] data;
        //--------------------------------------------------------------------------
        // Quiz stuff
        //--------------------------------------------------------------------------
        System.out.print("How many QUIZ scores? ");
        int howMany = inFromUser.nextInt();
        data = new double[howMany];
        
        System.out.print("Enter QUIZ scores: ");
        
        double userVal;
        for (int i = 0; i < howMany; i++) {
            userVal = inFromUser.nextDouble();
            data[i] = userVal;
        }
        double QUIZ_Max = FindMax(data);
        double QUIZ_Min = FindMin(data);
        double QUIZ_Raw_Average = RawAverage(data,quizMax);
        double QUIZ_Adjust_Average = Adjustaverage(data,quizMax);
        double QUIZ_Standard_Average = StandardDeviation(data,quizMax);
        System.out.println();

        System.out.println("QUIZ summary");
        System.out.println("----------------------------");
        print1(howMany,QUIZ_Min,QUIZ_Max,QUIZ_Raw_Average,QUIZ_Adjust_Average,QUIZ_Standard_Average);  
        System.out.println();
        System.out.println();
        //--------------------------------------------------------------------------
        // Lab stuff
        //--------------------------------------------------------------------------
        System.out.print("How many LAB scores? ");
        howMany = inFromUser.nextInt();
        data = new double[howMany];
        
        System.out.print("Enter LAB scores: ");
        for (int i = 0; i < howMany; i++) {
            userVal = inFromUser.nextDouble();
            data[i] = userVal;
        }
        
        double LAB_Max = FindMax(data);
        double LAB_Min = FindMin(data);
        double LAB_Raw_Average = RawAverage(data,labMax);
        double LAB_Adjust_Average = Adjustaverage(data,labMax);
        double LAB_Standard_Average = StandardDeviation(data,labMax);
        System.out.println();
        System.out.println("LAB summary");
        System.out.println("----------------------------");
        print1(howMany,LAB_Min,LAB_Max,LAB_Raw_Average,LAB_Adjust_Average,LAB_Standard_Average);
        System.out.println();
        
        //--------------------------------------------------------------------------
        // Program stuff
        //--------------------------------------------------------------------------
        System.out.print("How many PROGRAM scores? ");
        howMany = inFromUser.nextInt();
        data = new double[howMany];
        System.out.print("Enter PROGRAM scores: ");
        for (int i = 0; i < howMany; i++) {
            userVal = inFromUser.nextDouble();
            data[i] = userVal;
        }
        double PROGRAM_Max = FindMax(data);
        double PROGRAM_Min = FindMin(data);
        double PROGRAM_Raw_Average = RawAverage(data,progMax);
        double PROGRAM_Standard_Average = StandardDeviation(data,progMax);
        System.out.println();
        System.out.println("PROGRAM summary");
        System.out.println("----------------------------");
        print2(howMany,PROGRAM_Min,PROGRAM_Max,PROGRAM_Raw_Average,PROGRAM_Standard_Average);
        System.out.println();
        
        //--------------------------------------------------------------------------
        // Exam stuff
        //--------------------------------------------------------------------------
        System.out.print("How many EXAM scores? ");
        howMany = inFromUser.nextInt();
        data = new double[howMany];
        
        System.out.print("Enter EXAM scores: ");

        for (int i = 0; i < howMany; i++) {
            userVal = inFromUser.nextDouble();
            data[i] = userVal;
        }
        double EXAM_Max = FindMax(data);
        double EXAM_Min = FindMin(data);
        double EXAM_Raw_Average = RawAverage(data,examMax);
        double EXAM_Standard_Average = StandardDeviation(data,examMax);
        System.out.println();

        System.out.println("EXAM summary");
        System.out.println("----------------------------");
        print2(howMany,EXAM_Min,EXAM_Max,EXAM_Raw_Average,EXAM_Standard_Average);
        System.out.println();
        System.out.println();

        System.out.println("FINAL summary");
        System.out.println("------------------------------------");
        double finalgrades = QUIZ_Adjust_Average * quizWeight + LAB_Adjust_Average * labWeight +
                             PROGRAM_Raw_Average * progWeight + EXAM_Raw_Average * examWeight;
        String gradeLetter;
        gradeLetter = judgegrade(finalgrades);
        finalgrades = ((int)finalgrades)/100.0;
        System.out.println("Final grade adjusted average: "+ finalgrades);
        System.out.println(" Final grade adjusted letter: "+ gradeLetter);
        System.out.println();
        System.out.println("DONE. Normal termination.");
        
    }
    public static double FindMin(double[] inArray){
        double Min = inArray[0];
        for (int i = 1; i < inArray.length;i++){
            if (inArray[i] < Min){
                Min = inArray[i];
            }
        }
        return Min;
    }
    public static double FindMax(double[] inArray){
        double Max = inArray[0];
        for (int i = 1; i < inArray.length;i++){
            if (inArray[i] > Max){
                Max = inArray[i];
            }
        }
        return Max;
    }
    public static double RawAverage(double[] inArray,double scoresMax){
        double total = 0,num,
               rawaverage;
        for (int i = 0; i < inArray.length;i++){
            total =  total + inArray[i];
        }
        num = total / (double)(inArray.length);
        rawaverage = ((int)((num / scoresMax) * 100))/100.0;
        return rawaverage;
    }
    public static double Adjustaverage(double[] inArray,double scoresMax){
        double total = 0,
               Adjustaverage;
        for (int i = 0; i < inArray.length;i++){
            total =  total + inArray[i];
        }
        double Min = FindMin(inArray);
        Adjustaverage = ((int)((total - Min) / (inArray.length-1) / scoresMax * 100))/100.0;
        return Adjustaverage;
    }
    public static double StandardDeviation(double[] inArray,double scoresMax){
        double average,totalaverage = 0;
        for (int i = 0; i < inArray.length; i++){
            totalaverage = totalaverage + inArray[i];
        }
        average = totalaverage / inArray.length;
        double Total = 0;
        for (int i = 0; i < inArray.length; i++){
            Total = Total + (inArray[i] - average) * (inArray[i] - average);
        }
        double num = Math.sqrt(Total / (inArray.length));
        num = ((int)(num * 100))/100.0;
        return num;
    }
    public static void print1(int num, double Min, double Max, double Average, double Adjust,double StanD){
        System.out.println("              How many: "+ num );
        System.out.println("                   Min: "+ Min );
        System.out.println("                   Max: "+ Max );
        System.out.println("           Raw average: "+ Average );
        System.out.println("      Adjusted average: "+ Adjust );
        System.out.println("Raw standard deviation: "+ StanD );
    } 
    public static void print2(int num, double Min, double Max, double Average,double StanD){
        System.out.println("              How many: "+ num );
        System.out.println("                   Min: "+ Min );
        System.out.println("                   Max: "+ Max );
        System.out.println("           Raw average: "+ Average );
        System.out.println("Raw standard deviation: "+ StanD );
    }
    public static String judgegrade(double grade){
        String letter = "";
        if (grade > A_MIN){
            letter =  "A";
        }
        if ((grade < A_MIN) && (grade > A_MINUS_MIN)){
            letter =  "A-";
        }
        if ((grade < A_MINUS_MIN) && (grade > B_PLUS_MIN)){
            letter =  "B+";
        }
        if ((grade < B_PLUS_MIN) && (grade > B_MIN)){
            letter =  "B";
        }
        if ((grade < B_MIN) && (grade > B_MINUS_MIN)){
            letter =  "B-";
        }
        if ((grade < B_MINUS_MIN) && (grade > C_PLUS_MIN)){
            letter =  "C+";
        }
        if ((grade < C_PLUS_MIN) && (grade > C_MIN)){
            letter =  "C";
        }
        if ((grade < C_MIN) && (grade > C_MINUS_MIN)){
            letter =  "C-";
        }
        if ((grade < C_MINUS_MIN) && (grade > D_PLUS_MIN)){
            letter =  "D+";
        }
        if ((grade < D_PLUS_MIN) && (grade > D_MIN)){
            letter =  "D";
        }
        if ((grade < D_MIN) && (grade > D_MINUS_MIN)){
            letter =  "D-";
        }
        if ((grade < D_MINUS_MIN) && (grade > F_MIN)){
            letter =  "F";
        }
        return letter;
    }
}
