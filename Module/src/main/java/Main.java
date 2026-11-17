public class Main {

    // comparing merge sort using arrays to quick sort

    // Merge sort that gives sorted int array
    public static int[] mergeSort(int[] array){

        if(array.length <= 1){
            return array;
        }

        int mid = array.length / 2;
//        System.out.println(mid);
        int[] firstHalf = new int[mid];
//        System.out.println(array.length - mid);
        int[] secondHalf = new int[array.length - mid];

        for(int i = 0; i < firstHalf.length; i++){
            firstHalf[i] = array[i];
//            System.out.println("First Half: " + firstHalf[i]);
        }

        for(int i = 0; i < secondHalf.length; i++){
            secondHalf[i] = array[i + mid];
//            System.out.println("Second Half: " + secondHalf[i]);
        }

        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);

        return mergeHelper(firstHalf, secondHalf);

    }

    // Helper method for merge that sorts between two given arrays & returns single array
    public static int[] mergeHelper(int[] left, int[] right){

        int sorted[] = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                sorted[k++] = left[i++];
            } else {
                sorted[k++] = right[j++];
            }
        }

        while (i < left.length) {
            sorted[k++] = left[i++];
        }

        while (j < right.length) {
            sorted[k++] = right[j++];
        }

//        for(int p = 0; p < sorted.length; p++){
////            System.out.println(sorted[p]);
//        }
        return sorted;

    }

    // Quick sort method given int array
    public static int[] quickSort(int[] array){

        if(array.length <= 1){
            return array;
        }

        int pivot = array[0];

        int lessCount = 0;

        for(int i = 1; i < array.length; i++){
            if(array[i] < pivot){
                lessCount++;
            }
        }

        int[] less = new int[lessCount];
        int[] more = new int[(array.length-1) - lessCount];

        int lessIndex = 0;
        int moreIndex = 0;

        for(int i = 1; i < array.length; i++){
            if(array[i] < pivot){
                less[lessIndex] = array[i];
//                System.out.println("Less: " + array[i]);
                lessIndex++;
            } else {
                more[moreIndex] = array[i];
//                System.out.println("More: " + array[i]);
                moreIndex++;
            }
        }

        less = quickSort(less);
        more = quickSort(more);

        int[] sorted = new int[array.length];

        int index = 0;
        for(int elt : less){
            sorted[index] = elt;
//            System.out.println(Arrays.toString(sorted));
            index++;
        }

        sorted[index] = pivot;
//        System.out.println(Arrays.toString(sorted));
        index++;

        for(int elt : more){
            sorted[index] = elt;
//            System.out.println(Arrays.toString(sorted));
            index++;
        }
        return sorted;

    }

}
