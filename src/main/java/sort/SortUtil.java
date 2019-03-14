package sort;
//10 Sort Method https://www.cnblogs.com/onepixel/articles/7674659.html
public class SortUtil {
    public static void bubbleSort(int[] needSortedNumbers) {
        if (needSortedNumbers != null && needSortedNumbers.length > 0) {
            int length = needSortedNumbers.length;
            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (needSortedNumbers[j] > needSortedNumbers[j + 1]) {
                        swap(needSortedNumbers, j, j+1);
                    }
                }
                
            }
        }
    }
    public static void bubbleSort2(int[] needSortedNumbers) {
        if (needSortedNumbers != null && needSortedNumbers.length > 0) {
            int length = needSortedNumbers.length;
            for (int i = 0; i > length; i++) {
                for (int j = 0; j < length - i -1; j++) {
                    if (needSortedNumbers[j] > needSortedNumbers[j + 1]) {
                        swap(needSortedNumbers, j, j+1);
                    }
                }
                
            }
        }
    }
    
    
    public static void selectSort(int[] needSortNumbers) {
        if (isNotEmptyArray(needSortNumbers)) {
            int length = needSortNumbers.length;
            int minIndex = 0;
            for (int i = 0; i < length; i++) {
                minIndex = i;
                for (int j = i + 1; j < length; j++) {
                    if (needSortNumbers[j] < needSortNumbers[minIndex]) {
                        // Need not swap here, only need to get the smallest number index
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    swap(needSortNumbers, minIndex, i);
                }
            }
        }
    }
    
    public static boolean isNotEmptyArray(int[] numbers) {
        return numbers != null && numbers.length > 0;
    }
    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }
    
    
    
    public static void heapSort(int[] numbers) {
        if (isNotEmptyArray(numbers)) {
            buildMaxHeap(numbers);
            int lastIndex = numbers.length - 1;
            while(lastIndex > 0) {
                swap(numbers, 0, lastIndex);
                if (--lastIndex == 0) {
                    break;
                }
                adjustHeap(numbers, 0, lastIndex);
            }
            
        }
    }
    
    private static void buildMaxHeap(int[] numbers) {
        int lastIndex = numbers.length - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {//build heap from down to up
            int rootIndex = i;
            adjustHeap(numbers, rootIndex, lastIndex);
        }
    }
    
    private static void adjustHeap(int[] numbers, int parentIndex, int lastIndex) {// adjust from top to down
        int biggerIndex = parentIndex;
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;
        
        
        if (rightChildIndex <= lastIndex) {// right child exist
            if (numbers[rightChildIndex] > numbers[parentIndex] || numbers[leftChildIndex] > numbers[parentIndex]) {
                biggerIndex = numbers[rightChildIndex] > numbers[leftChildIndex]  ? rightChildIndex : leftChildIndex;
            }
        } else if (leftChildIndex <= lastIndex){// right child not exist, only exist left child
            if (numbers[leftChildIndex] > numbers[parentIndex]) {
                biggerIndex = leftChildIndex;
            }
        }
        if (biggerIndex != parentIndex) {
            swap(numbers, biggerIndex, parentIndex);
            adjustHeap(numbers, biggerIndex, lastIndex);
        }
    }
}
