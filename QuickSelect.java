import java.util.Arrays;
import java.util.Scanner;

public class QuickSelect {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Request and read the total number of elements from the user
        System.out.print("Enter the number of elements in the array: ");
        int totalElements = inputScanner.nextInt();

        // Initialize array and read its elements from the user
        int[] targetArray = new int[totalElements];
        System.out.print("Enter the elements of the array, separated by spaces: ");
        for (int index = 0; index < totalElements; index++) {
            targetArray[index] = inputScanner.nextInt();
        }

        // Request and read the value of k from the user
        System.out.print("Enter the value of k (k-th smallest element to find): ");
        int kValue = inputScanner.nextInt();

        // Validate the entered value of k
        if (kValue <= 0 || kValue > totalElements) {
            System.out.println("Invalid value of k. It should be between 1 and " + totalElements + ".");
            System.exit(1); // Exit program with error code 1
        }

        // Call quickSelect function and display the result
        System.out.println("K-th smallest element is " + quickSelect(targetArray, 0, totalElements - 1, kValue - 1));
    }

    // Recursively find k-th smallest element
    private static int quickSelect(int[] array, int startIdx, int endIdx, int k) {
        if (startIdx <= endIdx) {
            int pivotValue = findMedianOfMedians(array, startIdx, endIdx);
            int partitionIdx = partition(array, startIdx, endIdx, pivotValue);
            if (partitionIdx == k) {
                return array[partitionIdx];
            } else if (partitionIdx > k) {
                return quickSelect(array, startIdx, partitionIdx - 1, k);
            } else {
                return quickSelect(array, partitionIdx + 1, endIdx, k);
            }
        }
        return Integer.MAX_VALUE;
    }

    // Find median of medians for given array section
    private static int findMedianOfMedians(int[] array, int startIdx, int endIdx) {
        int numElements = endIdx - startIdx + 1;
        int groupCount = (int) Math.ceil((double) numElements / 5);
        int[] medians = new int[groupCount];

        // Find median for each group of five elements
        for (int i = 0; i < groupCount; i++) {
            int groupStartIdx = startIdx + i * 5;
            int groupEndIdx = Math.min(groupStartIdx + 4, endIdx);
            medians[i] = findMedian(array, groupStartIdx, groupEndIdx);
        }

        // Select median of medians using quick select
        return (medians.length == 1) ? medians[0] : quickSelect(medians, 0, medians.length - 1, medians.length / 2);
    }

    // Sort and find median of a given section of the array
    private static int findMedian(int[] array, int startIdx, int endIdx) {
        Arrays.sort(array, startIdx, endIdx + 1);
        return array[startIdx + (endIdx - startIdx) / 2];
    }

    // Partition array around the pivot value
    private static int partition(int[] array, int startIdx, int endIdx, int pivotValue) {
        // Locate and move pivot to end of the section
        for (int i = startIdx; i <= endIdx; i++) {
            if (array[i] == pivotValue) {
                swap(array, i, endIdx);
                break;
            }
        }
        
        // Reorder array elements based on comparison with pivot
        int partitionIdx = startIdx;
        for (int i = startIdx; i < endIdx; i++) {
            if (array[i] <= pivotValue) {
                swap(array, i, partitionIdx);
                partitionIdx++;
            }
        }
        // Move pivot to its final position
        swap(array, partitionIdx, endIdx);
        return partitionIdx;
    }

    // Swap two elements in the array
    private static void swap(int[] array, int idx1, int idx2) {
        int temporary = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temporary;
    }
}
