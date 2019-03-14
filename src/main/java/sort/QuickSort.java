package sort;

public class QuickSort {
    //https://blog.csdn.net/morewindows/article/details/6684558
    //https://blog.csdn.net/N_sev7/article/details/78057111
    
    public static void sort(int[] numbers) {
        if (SortUtil.isNotEmptyArray(numbers)) {
            
            partition(numbers, 0, numbers.length-1);
        }
    }
    
    public static void sort2(int[] numbers) {
        if (SortUtil.isNotEmptyArray(numbers)) {
            
            partition2(numbers, 0, numbers.length-1);
        }
    }
    
    
    private static void partition(int[] numbers, int low, int high) {
        //https://blog.csdn.net/u010853261/article/details/54884784
        if (low <= high) {
            int left = low;
            int right = high;
            int baseNumber = numbers[left];
            while (left != right) {
                while(numbers[right] >= baseNumber && left < right) {
                    right--;
                }
                numbers[left] = numbers[right];
                while(numbers[left] <= baseNumber && left < right) {
                    left++;
                }
                numbers[right] = numbers[left];
            }
            numbers[left] = baseNumber;
            partition(numbers, 0, left - 1);
            partition(numbers, left + 1, high);
        }
    }
    
    private static void partition2(int[] numbers, int low, int high) {
        //https://blog.csdn.net/vayne_xiao/article/details/53508973
        if (low <= high) {
            int left = low;
            int right = high;
            int baseNumber = numbers[left];
            while (left != right) {
                while(numbers[right] >= baseNumber && left < right) {
                    right--;
                }
                while(numbers[left] <= baseNumber && left < right) {
                    left++;
                }
                if (left <right) {
                    SortUtil.swap(numbers, left, right);
                }
            }
            numbers[low] = numbers[left];
            numbers[left] = baseNumber;
            partition2(numbers, 0, left - 1);
            partition2(numbers, left + 1, high);
        }
    }
}
