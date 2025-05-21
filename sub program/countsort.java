
public class CountSort {
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        // Find the range of input array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // Create count array
        int[] count = new int[max + 1];
        
        // Store count of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        // Modify count array to store actual position
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        
        // Create output array
        int[] output = new int[arr.length];
        
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        
        // Copy output array to input array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        countSort(arr);
        
        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
