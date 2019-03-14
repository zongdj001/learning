package sort;

public class SelectSort {
    
    public static void selectSort(int[] numbers) {
        
        if (numbers != null && numbers.length > 0) {
            //every time select one smallest number
            int lastIndex = numbers.length - 1;
            int needAdjustIndex = 0;
            for (int i = 0; i <= lastIndex; i ++) {
                needAdjustIndex = i;
                for (int j = i; j <= lastIndex; j++) {
                    if (numbers[needAdjustIndex] > numbers[j]) {
                        needAdjustIndex = j;
                    }
                }
                if (needAdjustIndex != i) {
                    SortUtil.swap(numbers, needAdjustIndex, i);
                }
            }
        }
    }
    
}
