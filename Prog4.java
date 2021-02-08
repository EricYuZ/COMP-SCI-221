import java.util.*;

/*
* computes your final course grade, based on a weighted-average 
formula, i.e., an average in which each term is multiplied by a significance factor.
* Zeyang Yu & Chenyu Li
*/
public class Prog4 {
    /*
     * Set all the percentage of the score maches with the grade's letters you need to reach.
     * Chenyu Li 
     */
    public static final double A_PCT = 0.91; 
    public static final double A_MINUS_PCT = 0.89; 
    public static final double B_PLUS_PCT = 0.87;
    public static final double B_PCT = 0.81;
    public static final double B_MINUS_PCT = 0.79;
    public static final double C_PLUS_PCT = 0.77;
    public static final double C_PCT = 0.71;
    public static final double C_MINUS_PCT = 0.69;
    public static final double D_PLUS_PCT = 0.67;
    public static final double D_PCT = 0.61;
    public static final double D_MINUS_PCT = 0.55;
    public static final double F_PCT = 0.0;
    public static final double PCT_CONV = 100.0;

    /*
     * 
     */
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter weights (quizzes, labs, programs, exams): ");
        int quizWeight = input.nextInt(),
            labWeight = input.nextInt(),
            programWeight = input.nextInt(),
            examWeight = input.nextInt(); 
            
        System.out.print("Enter maximum scores (quizzes, labs, programs, exams): ");
        int quizMax = input.nextInt(),
            labMax = input.nextInt(),
            programMax = input.nextInt(),
            examMax = input.nextInt(); 
            
        double quizPct = processType(input, "QUIZ", quizMax, true),
               labPct = processType(input, "LAB", labMax, true),
               programPct = processType(input, "PROGRAM", programMax, false),
               examPct = processType(input, "EXAM", examMax, false);
              
        double finalPct = (quizWeight / PCT_CONV) * quizPct +
                          (labWeight / PCT_CONV) * labPct +
                          (programWeight / PCT_CONV) * programPct +
                          (examWeight / PCT_CONV) * examPct;      
        finalPct = ((int)(finalPct * 100))/100.0;
        printFinalSummary(finalPct);
    }

    /*
     * The equation for how to calculate the maximum score, minimum score, raw average, 
     * adjust average, and standard deviation.
     * Zeyang Yu
     */
    public static double processType(Scanner in, 
                                     String inType, 
                                     int inMax, 
                                     boolean dropOne) { 
        double pct = 0.0;
        double[] data;
        double userVal;
        printAskNum(inType);
        int howMany = in.nextInt();
        data = new double[howMany];
        printEnter(inType);
        for (int i = 0; i < howMany; i++) {
            data[i] = in.nextDouble();
        }
        System.out.println();
        double Score_Max = findMax(data);
        double Score_Min = findMin(data);
        double Score_Raw_Average = rawAverage(data,inMax);
        double Score_Adjust_Average = adjustAverage(data,inMax);
        double Score_Standard_Average = standardDeviation(data,inMax);
        if (dropOne) {
            printTrue(howMany,Score_Min,Score_Max,Score_Raw_Average,
                      Score_Adjust_Average,Score_Standard_Average,inType);
        }
        else printFalse(howMany,Score_Min,Score_Max,
                        Score_Raw_Average,Score_Standard_Average,inType);
        if (dropOne) {
            pct = Score_Adjust_Average;
        }
        else pct = Score_Raw_Average;
        return pct;
    }
    
    /*
     * Find the minimum score for each section.(Quiz, Lab, Program, and Exam)
     * Chenyu Li
     */
    public static double findMin(double[] inArray){
        double Min = inArray[0];
        for (int i = 1; i < inArray.length;i++){
            if (inArray[i] < Min){
                Min = inArray[i];
            }
        }
        return Min;
    }
    
   /*
    * Find the maximum score for each section.(Quiz, Lab, Program,and Exam)
    * Chenyu Li
    */
    public static double findMax(double[] inArray){
        double Max = inArray[0];
        for (int i = 1; i < inArray.length;i++){
            if (inArray[i] > Max){
                Max = inArray[i];
            }
        }
        return Max;
    }
    
    /*
     * Calculate the raw average for each part of the section.(Quiz, Lab, Program, and Exam)
     * Zeyang Yu
     */
    public static double rawAverage(double[] inArray,double scoresMax){
        double total = 0,num,
               rawaverage;
        for (int i = 0; i < inArray.length;i++){
            total =  total + inArray[i];
        }
        num = total / (double)(inArray.length);
        rawaverage = ((int)((num / scoresMax) * 100))/100.0;
        return rawaverage;
    }
    
    /*
     * Calculate the adjust average for each part of the section.(Quiz and Lab)
     * Zeyang Yu
     */
    public static double adjustAverage(double[] inArray,double scoresMax){
        double total = 0,
               Adjustaverage;
        for (int i = 0; i < inArray.length;i++){
            total =  total + inArray[i];
        }
        double Min = findMin(inArray);
        Adjustaverage = ((int)((total - Min) / (inArray.length-1) / scoresMax * 100))/100.0;
        return Adjustaverage;
    }
    
    /*
     * Calculate the standard Deviation for each part of the 
     * section.(Quiz, Lab, Program, and Exam)
     * Zeyang Yu
     */
    public static double standardDeviation(double[] inArray,double scoresMax){
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
    
    /*
     * Ask users to enter how many times did they were scroed 
     * by for each section.(Quiz, Lab, Program, and Exam)
     * Chenyu Li
     */
    public static void printAskNum(String type){
        System.out.println();
        System.out.print("How many " + type +" scores? ");
    }
    
    /* 
     * Ask users to enter the scores they get 
     * every time for each section.(Quiz, Lab, Program, and Exam)
     * Chenyu Li
     */
    public static void printEnter(String type){
        System.out.print("Enter " + type +" scores: ");
    }
    
    /*
     * Output the results of how many times the users had been scored, minimum score, maximum
     * score, raw average, adjusted average, and standard deviation for two section.(Quiz and
     * Lab)
     * Zeyang Yu
     */
    public static void printTrue(int num, double Min, double Max, 
                                 double Average, double Adjust,
                                 double StanD, String type){
        System.out.println(type + " summary");
        System.out.println("----------------------------");
        System.out.println("              How many: "+ num );
        System.out.println("                   Min: "+ Min );
        System.out.println("                   Max: "+ Max );
        System.out.println("           Raw average: "+ Average );
        System.out.println("      Adjusted average: "+ Adjust );
        System.out.println("Raw standard deviation: "+ StanD );
    } 
    
    /*
     * Output the results of how many times the users had been scored, minimum score, maximum
     * score, raw average, and standard deviation for the other two section.(Program and Exam)
     * Chenyu Li
     */
    public static void printFalse(int num, double Min, double Max, 
                                  double Average,double StanD,String type){
        System.out.println(type + " summary");
        System.out.println("----------------------------");
        System.out.println("              How many: "+ num );
        System.out.println("                   Min: "+ Min );
        System.out.println("                   Max: "+ Max );
        System.out.println("           Raw average: "+ Average );
        System.out.println("Raw standard deviation: "+ StanD );
    }
    
    /*
     * Output the resuts for the final grade.
     * Chenyu Li
     */
    public static void printFinalSummary(double finalPct) {
        System.out.println();
        System.out.println();
        System.out.println("FINAL summary");
        System.out.println("------------------------------------");
        System.out.println("Final grade adjusted average: "+ finalPct);
        System.out.println(" Final grade adjusted letter: "+ judgeGrade(finalPct));
        System.out.println();
        System.out.println("DONE. Normal termination.");
    }
    
    /*
     * Determine which letter grade the user get based on the percentage of the final grade.
     * Zeyang Yu
     */
    public static String judgeGrade(double grade){
        String letter = "";
        if (grade > A_PCT){
            letter =  "A";
        }
        if ((grade < A_PCT) && (grade > A_MINUS_PCT)){
            letter =  "A-";
        }
        if ((grade < A_MINUS_PCT) && (grade > B_PLUS_PCT)){
            letter =  "B+";
        }
        if ((grade < B_PLUS_PCT) && (grade > B_PCT)){
            letter =  "B";
        }
        if ((grade < B_PCT) && (grade > B_MINUS_PCT)){
            letter =  "B-";
        }
        if ((grade < B_MINUS_PCT) && (grade > C_PLUS_PCT)){
            letter =  "C+";
        }
        if ((grade < C_PLUS_PCT) && (grade > C_PCT)){
            letter =  "C";
        }
        if ((grade < C_PCT) && (grade > C_MINUS_PCT)){
            letter =  "C-";
        }
        if ((grade < C_MINUS_PCT) && (grade > D_PLUS_PCT)){
            letter =  "D+";
        }
        if ((grade < D_PLUS_PCT) && (grade > D_PCT)){
            letter =  "D";
        }
        if ((grade < D_PCT) && (grade > D_MINUS_PCT)){
            letter =  "D-";
        }
        if (grade < D_MINUS_PCT) {
            letter =  "F";
        }
        return letter;
    }

}
