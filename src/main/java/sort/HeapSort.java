package sort;

public class HeapSort {
    
    public static void heapSort(int[] numbers) {
        // build a heap first
        // adjust
        
        //https://blog.csdn.net/tanga842428/article/details/52635656 TOOD, not 递归
        
        //https://www.cnblogs.com/chengxiao/p/6129630.html
        
        if (numbers != null && numbers.length > 0) {
            buildMaxHeap(numbers);
            
            for (int lastIndex = numbers.length - 1; lastIndex >= 0; lastIndex--) {
                swap(numbers, 0, lastIndex);
                
                adjustHeap(numbers, 0, lastIndex-1);
            }
            
        }
    }
    private static void buildMaxHeap(int[] numbers) {
        int lastIndex = numbers.length - 1 ;
        int from = (lastIndex - 1 ) / 2; // or (numbers.length /2  -1)
        for (int i = from; i >= 0; i-- ) {
            adjustHeap(numbers, i, lastIndex);
        }
        
    }
    private static void adjustHeap(int[] numbers, int parentIndex, int lastIndex) {
        
        int biggerNumberIndex = parentIndex;
        
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;
        
        if (rightChildIndex <= lastIndex) { // right child exist
            if (numbers[rightChildIndex] > numbers[parentIndex] || numbers[leftChildIndex] > numbers[parentIndex]) {
                biggerNumberIndex = numbers[rightChildIndex] > numbers[leftChildIndex] ? rightChildIndex : leftChildIndex;
            }
        } else if (leftChildIndex <= lastIndex) { // only exist left child
            if (numbers[leftChildIndex] > numbers[parentIndex]) {
                biggerNumberIndex = leftChildIndex;
            }
        }
        if (biggerNumberIndex != parentIndex) {
            swap(numbers, parentIndex, biggerNumberIndex);
            adjustHeap(numbers, biggerNumberIndex, lastIndex);
        }
        
    }
    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }
    
    
}
