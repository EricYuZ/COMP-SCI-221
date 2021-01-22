 import java.util.*;

public class Lab8 {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you want? ");
        int howMany = in.nextInt();
        int[] myArray;
        Random rand = new Random(1234);

        myArray = new int[howMany]; // Step 4
        
        for (int i = 0; i < howMany; i++) {   // Step 5
            myArray[i] = rand.nextInt(1000);
        }
        System.out.print("myArray before reverseInPlace: ");
        printArray(myArray); // Step 6
        
        reverseInPlace(myArray); // Step 7
        System.out.print("myArray after reverseInPlace: ");
        printArray(myArray); // Step 8
        System.out.println(" ");
        int[] anotherArray = reverseDoNotModify(myArray); // Step 9
        System.out.print("myArray after reverseDoNotModify: ");
        printArray(myArray); // Step 10.0
        System.out.print("Returned array from reverseDoNotModify: ");
        printArray(anotherArray); // Step 10.1
    }   
    
    // The output format is NOT satisfied. Make sure
    // you make modifications to ensure the output
    // requirements are satisfied. 
    
    // Day16
    public static void printArray(int[] printMe) {
        if (printMe.length == 0) {
            System.out.println("[ ]");
            return;
        }
        for (int i = 0; i < printMe.length - 1; i++) {
            System.out.print(printMe[i] + " ");
        }
        System.out.println(printMe[printMe.length - 1]);
    }
    
    public static void reverseInPlace(int[] inArray) {
        for (int i = 0; i < inArray.length/2; i++){
            int temp = inArray[i];
            inArray[i] = inArray[inArray.length-i-1];
            inArray[inArray.length-i-1] = temp;
        }
    }
    
    public static int[] reverseDoNotModify(int[] inArray) {
        int[] newArray = new int[inArray.length];
        for (int i = 0; i < inArray.length; i++){
            newArray[i] = inArray[inArray.length-i-1];
        }
        return newArray;
    }
}