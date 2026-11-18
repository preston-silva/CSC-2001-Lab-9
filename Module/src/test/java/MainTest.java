import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    int[] testArraySorted = new int[]{1,2,3,4,5,6,7,8,9};
    int[] testArrayUnsorted = new int[]{3,9,6,7,5,8,2,4,1};

    @Test
    public void testMergeSort(){
        // Odd
        assertArrayEquals(testArraySorted, Main.mergeSort(testArrayUnsorted));

        // Even
        testArraySorted = new int[]{0,1,2,3,4,5,6,7,8,9};
        testArrayUnsorted = new int[]{3,9,6,7,0,5,8,2,4,1};
        assertArrayEquals(testArraySorted, Main.mergeSort(testArrayUnsorted));
    }

    @Test
    public void testQuickSort(){
        // Odd
        assertArrayEquals(testArraySorted, Main.quickSort(testArrayUnsorted));

        // Even
        testArraySorted = new int[]{0,1,2,3,4,5,6,7,8,9};
        testArrayUnsorted = new int[]{3,9,6,7,0,5,8,2,4,1};
        assertArrayEquals(testArraySorted, Main.quickSort(testArrayUnsorted));
    }

    @Test
    public void testMergeTime(){

        IO.println("Merge Time: ");
        for(int i = 1; i < 1000000000; i *= 10){

            int[] testArray = Main.arrayGenerator(i);

            IO.println("Size: " + i);
            long startTime = System.nanoTime();
            Main.mergeSort(testArray);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1000.0;
            IO.println("Time: " + duration + " microseconds\n");

        }

    }

    @Test
    public void testQuickTime(){

        IO.println("Quick Time: ");
        for(int i = 1; i < 1000000000; i *= 10){

            int[] testArray = Main.arrayGenerator(i);

            IO.println("Size: " + i);
            long startTime = System.nanoTime();
            Main.quickSort(testArray);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1000.0;
            IO.println("Time: " + duration + " microseconds\n");

        }
    }

}
