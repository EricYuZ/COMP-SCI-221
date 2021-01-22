import java.util.*;

public class Lab9 {
    public static void main(String args[]) {
        System.out.print("How many numbers do you want? ");
        Scanner in = new Scanner(System.in);
        int howMany = in.nextInt();
        int[] array = getRandomArray(howMany);
        System.out.print("Here is a random sorted array: ");
        array = SlectSort(array);
        printArray(array);
        System.out.print("For what value would you like to search? ");
        int SearchNum = in.nextInt();
        in.close();
        int index = bsearch(array,SearchNum);
        if (index == -1){
            System.out.println("The value " + SearchNum +" does not occur in the array.");
        }
        else{
            System.out.println("The value "+ SearchNum +" occurs at index " + index);
        }
    }

    public static int[] SlectSort(int[] array){
        int indexSmallest, temp;
        for (int i = 0; i < array.length - 1; ++i) {
            indexSmallest = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            temp = array[i];
            array[i] = array[indexSmallest];
            array[indexSmallest] = temp;
        }
        return array;
    }

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

    public static int bsearch(int[] arr, int key) {
        int mid;
        int low =0;
        int high;
        int index = -1;
        high = arr.length - 1;
        while (high >= low) {
            mid = (high + low) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } 
            else if (arr[mid] > key) {
                high = mid - 1;
            } 
            else {
                index = mid;
                break;
            }
        }
        if (index != -1){
            while (arr[index] == arr[index + 1]){
                index = index + 1; 
            }
        }
        return index;
    }

    public static int[] getRandomArray(int howMany) {
        if (howMany < 0)
            return null;
        int[] randomArray = new int[howMany];
        Random rand = new Random();
        for (int i = 0; i < howMany; i++) {   
            randomArray[i] = rand.nextInt(30);
        }
        return randomArray;
    }
}