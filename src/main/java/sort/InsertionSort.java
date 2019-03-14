package sort;

public class InsertionSort {
    
    public static void insertSort(int[] numbers) {
        if (numbers != null && numbers.length > 0) {
            int length = numbers.length;
            for (int i = 1; i < length; i++) {
                int currentNumber = numbers[i];
                int insertedPreviousIndex = i - 1;
                
                while (insertedPreviousIndex >= 0 && currentNumber < numbers[insertedPreviousIndex]) {
                    numbers[insertedPreviousIndex + 1] = numbers[insertedPreviousIndex];
                    insertedPreviousIndex--;
                }
                
                numbers[insertedPreviousIndex + 1] = currentNumber;
//                for (int j = i - 1; j >= 0; j--) {
//                    if (numbers[j] > currentNumber) {
//                        numbers[j + 1] = numbers [j];
//                    } else {
//                        numbers[j + 1] = currentNumber;
//                        break;
//                    }
//                    if (j == 0) {
//                        numbers[j] = currentNumber;
//                    }
//                }
            }
        }
    }
}
