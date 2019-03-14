package sort;

public class RadixSort {
    
    public static void sort(int[] numbers) {
        //https://blog.csdn.net/lemon_tree12138/article/details/51695211
        
        //https://www.cnblogs.com/oumyye/p/4522467.html
        if (SortUtil.isNotEmptyArray(numbers)) {
            int length = numbers.length;
            
            int[][] numbersBuket = new int[10][length];
            int max = getMax(numbers);
            int maxNumberLength = getNumberLength(max);
            int[] bucketIndex = new int[10];
            for (int j = 1; j <= maxNumberLength; j++) {
                //sort from 1 position number
                for (int i = 0; i < length; i++) {
                    int number = numbers[i];
                    int digit = getDigit(number, j);
                    numbersBuket[digit][bucketIndex[digit]] = number;
                    bucketIndex[digit]++;
                }
                int sortNumberIndex = 0;
                for (int i = 0; i < 10; i++) {
                    // collect
                    for (int index = 0; index < bucketIndex[i]; index ++) {
                        numbers[sortNumberIndex] = numbersBuket[i][index];
                        sortNumberIndex++;
                    }
                    bucketIndex[i] = 0;
                }
            }
            
           
            
        }
    }
    
    private static int getMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    public static int getNumberLength(int number) {
        int length = 1;
        int value = Math.abs(number);
        while (value / 10 != 0) {
           length++; 
           value = value / 10;
        }
        return length;
    }
    /**
     * 
     * @param number
     * @param pos start from 1
     * @return
     */
    private static int getDigit(int number, int pos) {
        int divder = 1;
        for (int i = 0; i < pos - 1; i++) {
            divder = divder * 10;
        }
        return (number / divder) % 10;
    }
    
}
