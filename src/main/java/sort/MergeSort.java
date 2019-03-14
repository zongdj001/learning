package sort;

public class MergeSort {
    
    public static void sort(int[] numbers) {
        // build a heap first
        // adjust
        
        //https://blog.csdn.net/tanga842428/article/details/52635656 TOOD, not 递归
        
        //https://blog.csdn.net/gdutxiaoxu/article/details/51292207
        
        if (numbers != null && numbers.length > 0) {
            int left = 0;
            int right = numbers.length - 1;
           // mergeSort(numbers, left, right);
            mergeSortNonRecursive(numbers);
        }
    }
    
    
    
    private static void mergeSort(int[] numbers, int left,  int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) /2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }
    
    
    private static void mergeSortNonRecursive(int[] numbers) {
        
        
        int step = 1;
        int length = numbers.length;
        
        int left = 0;
        int right;
        int mid;
        
        
        while (step <= length) {
            for (int i = 0; i + step <= length -1; i = i + 2 * step) {
                left = i;
                right = i + 2 * step -1;
                mid = i + step -1;
                if (right > length -1) {
                    right = length -1;
                }
                merge(numbers, left, mid, right);
                
            }
            step += step;
        }
        
        
        
        
    }
    private static void merge(int[] numbers, int first, int mid, int last) {
        
        
        int[] temp = new int[numbers.length];
        
        int leftSortedPartIndex = first;
        int rightSortedPartIndex = mid + 1;
        
        
        int tempIndex = first;
        
        while(leftSortedPartIndex <= mid && rightSortedPartIndex <= last) {
            if (numbers[leftSortedPartIndex] < numbers[rightSortedPartIndex]) {
                temp[tempIndex++] = numbers[leftSortedPartIndex++];
            } else {
                temp[tempIndex++] = numbers[rightSortedPartIndex++];
            }
        }
        
        while (leftSortedPartIndex <= mid) {
            temp[tempIndex++] = numbers[leftSortedPartIndex++];
        }
        
        while (rightSortedPartIndex <= last) {
            temp[tempIndex++] = numbers[rightSortedPartIndex++];
        }
        
        int startMergeIndex = first;
        while (startMergeIndex <= last) {
            numbers[startMergeIndex] = temp[startMergeIndex++];
        }
        
        
    }
    
}
